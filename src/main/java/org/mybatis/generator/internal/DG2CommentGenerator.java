package org.mybatis.generator.internal;

import org.mybatis.generator.api.IntrospectedColumn;
import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.dom.java.*;
import org.mybatis.generator.api.dom.xml.TextElement;
import org.mybatis.generator.api.dom.xml.XmlElement;

import java.util.Iterator;

/**
 * 自定义注解生成
 *
 * @author IT_donggua
 * @version V1.0
 * @create 2016-09-02 下午 06:28
 */
public class DG2CommentGenerator extends DefaultCommentGenerator {

    //生成model对象的注释信息
    @Override
    public void addClassComment(InnerClass innerClass, IntrospectedTable introspectedTable) {

        StringBuffer sb = new StringBuffer();
        sb.append("@ApiModel(value=\"").append(introspectedTable.getFullyQualifiedTable().getRemark()).append
                ("\",description=\"数据库表：").append
                (introspectedTable.getFullyQualifiedTable()).append
                ("\")");
        //添加通用mapper注释 @Table(name = "数据库表名")
        sb.append("@Table(name = \"" + introspectedTable.getFullyQualifiedTable() + "\")");
        innerClass.addJavaDocLine(sb.toString());

    }

    @Override
    public void addClassComment(InnerClass innerClass, IntrospectedTable introspectedTable, boolean markAsDoNotDelete) {
        // 类注释，不管用
        String shortName = innerClass.getType().getShortName();
        innerClass.addJavaDocLine("/**");
        innerClass.addJavaDocLine(" * 类注释");
        innerClass.addJavaDocLine(" * " + shortName);
        innerClass.addJavaDocLine(" * 数据库表：" + introspectedTable.getFullyQualifiedTable());
        // addJavadocTag(innerClass, false);
        innerClass.addJavaDocLine(" */");
    }

    //model对象中字段的注释
    @Override
    public void addFieldComment(Field field, IntrospectedTable introspectedTable, IntrospectedColumn introspectedColumn) {

        StringBuffer sb = new StringBuffer();

        if (introspectedColumn.getRemarks() != null) {
            sb.append("@ApiModelProperty(value=\"").append(introspectedColumn.getRemarks()).append("\",name=\"").append(introspectedColumn.getJavaProperty());
        }

        if (!(introspectedColumn.isNullable())) {
            sb.append("\", required=true)");
            field.addJavaDocLine(sb.toString());
        } else {
            sb.append("\")");
            field.addJavaDocLine(sb.toString());
        }

        if (!(introspectedColumn.isNullable())) {
            field.addAnnotation("@NotEmpty");
        }

        //添加通用mapper字段注解  @Column(name = "数据库字段")
        //如果是主键，需要添加@Id
        Iterator<IntrospectedColumn> primaryKeys = introspectedTable.getPrimaryKeyColumns().iterator();
        if (primaryKeys.hasNext()) {
            IntrospectedColumn primaryColumn1 = primaryKeys.next();
            if (introspectedColumn == primaryColumn1) {
                field.addAnnotation("@Id");
            }
        }

        field.addAnnotation("@Column(name = \"" + introspectedColumn.getActualColumnName() + "\")");

    }

    @Override
    public void addGetterComment(Method method, IntrospectedTable introspectedTable, IntrospectedColumn introspectedColumn) {
        StringBuilder sb = new StringBuilder();

        method.addJavaDocLine("/**"); //$NON-NLS-1$

        sb.append(" * 获取 "); //$NON-NLS-1$
        sb.append(introspectedColumn.getRemarks()).append(" 字段:");
        sb.append(introspectedTable.getFullyQualifiedTable());
        sb.append('.');
        sb.append(introspectedColumn.getActualColumnName());
        method.addJavaDocLine(sb.toString());

        method.addJavaDocLine(" *"); //$NON-NLS-1$

        sb.setLength(0);
        sb.append(" * @return "); //$NON-NLS-1$
        sb.append(introspectedTable.getFullyQualifiedTable());
        sb.append('.');
        sb.append(introspectedColumn.getActualColumnName());
        sb.append(", ");
        sb.append(introspectedColumn.getRemarks());
        method.addJavaDocLine(sb.toString());

        method.addJavaDocLine(" */"); //$NON-NLS-1$
    }

    @Override
    public void addSetterComment(Method method,
                                 IntrospectedTable introspectedTable,
                                 IntrospectedColumn introspectedColumn) {

        StringBuilder sb = new StringBuilder();

        method.addJavaDocLine("/**"); //$NON-NLS-1$

        sb.append(" * 设置 ");  //$NON-NLS-1$
        sb.append(introspectedColumn.getRemarks()).append(" 字段:");
        sb.append(introspectedTable.getFullyQualifiedTable());
        sb.append('.');
        sb.append(introspectedColumn.getActualColumnName());
        method.addJavaDocLine(sb.toString());

        method.addJavaDocLine(" *"); //$NON-NLS-1$

        Parameter parm = method.getParameters().get(0);
        sb.setLength(0);
        sb.append(" * @param "); //$NON-NLS-1$
        sb.append(parm.getName());
        sb.append(" the value for "); //$NON-NLS-1$
        sb.append(introspectedTable.getFullyQualifiedTable());
        sb.append('.');
        sb.append(introspectedColumn.getActualColumnName());
        sb.append(", ");
        sb.append(introspectedColumn.getRemarks());
        method.addJavaDocLine(sb.toString());

        method.addJavaDocLine(" */"); //$NON-NLS-1$
    }

    @Override
    public void addComment(XmlElement xmlElement) {

        StringBuilder sb = new StringBuilder();

        xmlElement.addElement(new TextElement("<!--" + "@mbggenerated" + "-->"));

    }
}
