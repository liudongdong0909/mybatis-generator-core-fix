package org.mybatis.generator.internal;

import org.mybatis.generator.api.IntrospectedColumn;
import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.dom.java.*;
import org.mybatis.generator.api.dom.xml.TextElement;
import org.mybatis.generator.api.dom.xml.XmlElement;
import org.mybatis.generator.internal.util.StringUtility;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;

/**
 * 自定义注解生成
 *
 * @author IT_donggua
 * @version V1.0
 */
public class DG2CommentGenerator extends DefaultCommentGenerator {

    //生成model对象的注释信息
    @Override
    public void addClassComment(InnerClass innerClass, IntrospectedTable introspectedTable) {

        innerClass.addJavaDocLine("/**"); //$NON-NLS-1$
        String remarks = introspectedTable.getFullyQualifiedTable().getRemark();
        if (StringUtility.stringHasValue(remarks)) {
            innerClass.addJavaDocLine(" * " + remarks);
        }
        innerClass.addJavaDocLine(" *"); //$NON-NLS-1$
        innerClass.addJavaDocLine(" * @author walle"); //$NON-NLS-1$
        innerClass.addJavaDocLine(" * @date " + new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
        innerClass.addJavaDocLine(" */"); //$NON-NLS-1$
    }

    //生成model对象的注释信息
    @Override
    public void addModelClassComment(TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {

        // StringBuilder sb = new StringBuilder();
        // topLevelClass.setSuperClass(new FullyQualifiedJavaType("RiskBaseModel"));

        topLevelClass.addImportedType(new FullyQualifiedJavaType("lombok.*"));
        // topLevelClass.addImportedType(new FullyQualifiedJavaType("lombok.experimental.SuperBuilder"));
        topLevelClass.addImportedType(new FullyQualifiedJavaType("javax.persistence.Id"));
        topLevelClass.addImportedType(new FullyQualifiedJavaType("javax.persistence.Table"));
        // topLevelClass.addImportedType(new FullyQualifiedJavaType("com.cloud.risk.model.RiskBaseModel"));

        topLevelClass.addImportedType(new FullyQualifiedJavaType("io.swagger.annotations.ApiModel"));
        topLevelClass.addImportedType(new FullyQualifiedJavaType("io.swagger.annotations.ApiModelProperty"));

        topLevelClass.addJavaDocLine("@Data");
        topLevelClass.addJavaDocLine("@NoArgsConstructor");
        topLevelClass.addJavaDocLine("@AllArgsConstructor");
        topLevelClass.addJavaDocLine("@Builder");
        // topLevelClass.addJavaDocLine("@SuperBuilder");
        // topLevelClass.addJavaDocLine("@AllArgsConstructor");
        StringBuffer sb = new StringBuffer();
        sb.append("@ApiModel(value=\"").append(introspectedTable.getFullyQualifiedTable().getRemark()).append
                ("\",description=\"数据库表：").append
                (introspectedTable.getFullyQualifiedTable()).append
                ("\")");
        //添加通用mapper注释 @Table(name = "数据库表名")
        topLevelClass.addJavaDocLine(sb.toString());
        topLevelClass.addJavaDocLine("@Table(name = \"" + introspectedTable.getFullyQualifiedTable() + "\")");
        // topLevelClass.addJavaDocLine("@Table(name = \"" + introspectedTable.getFullyQualifiedTable() +"\")");
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

        // sb.append("/**").append("\n");
        // sb.append("     * ");
        // sb.append(introspectedColumn.getRemarks()).append("\n");
        // sb.append("     */");

        // field.addJavaDocLine(sb.toString());

        field.addAnnotation("@ApiModelProperty(value=\"" + introspectedColumn.getRemarks() + "\",name=\"" + introspectedColumn.getJavaProperty() + "\")");
        //添加通用mapper字段注解  @Column(name = "数据库字段")
        //如果是主键，需要添加@Id
        Iterator<IntrospectedColumn> primaryKeys = introspectedTable.getPrimaryKeyColumns().iterator();
        if (primaryKeys.hasNext()) {
            IntrospectedColumn primaryColumn1 = primaryKeys.next();
            if (introspectedColumn == primaryColumn1) {
                field.addAnnotation("@Id");
            }
        }

        // field.addAnnotation("@Column(name = \"" + introspectedColumn.getActualColumnName() + "\")");

    }

    @Override
    public void addGetterComment(Method method, IntrospectedTable introspectedTable, IntrospectedColumn introspectedColumn) {
        // StringBuilder sb = new StringBuilder();
        //
        // method.addJavaDocLine("/**"); //$NON-NLS-1$
        //
        // sb.append(" * 获取 "); //$NON-NLS-1$
        // sb.append(introspectedColumn.getRemarks());
        // // sb.append(" 字段:");
        // // sb.append(introspectedTable.getFullyQualifiedTable());
        // // sb.append('.');
        // // sb.append(introspectedColumn.getActualColumnName());
        // method.addJavaDocLine(sb.toString());
        //
        // method.addJavaDocLine(" *"); //$NON-NLS-1$
        //
        // sb.setLength(0);
        // sb.append(" * @return "); //$NON-NLS-1$
        // // sb.append(introspectedTable.getFullyQualifiedTable());
        // // sb.append('.');
        // // sb.append(introspectedColumn.getActualColumnName());
        // // sb.append(", ");
        // sb.append(introspectedColumn.getRemarks());
        // method.addJavaDocLine(sb.toString());
        //
        // method.addJavaDocLine(" */"); //$NON-NLS-1$
    }

    @Override
    public void addSetterComment(Method method,
                                 IntrospectedTable introspectedTable,
                                 IntrospectedColumn introspectedColumn) {

        // StringBuilder sb = new StringBuilder();
        //
        // method.addJavaDocLine("/**"); //$NON-NLS-1$
        //
        // sb.append(" * 设置 ");  //$NON-NLS-1$
        // sb.append(introspectedColumn.getRemarks());
        // // sb.append(" 字段:");
        // // sb.append(introspectedTable.getFullyQualifiedTable());
        // // sb.append('.');
        // // sb.append(introspectedColumn.getActualColumnName());
        // method.addJavaDocLine(sb.toString());
        //
        // method.addJavaDocLine(" *"); //$NON-NLS-1$
        //
        // Parameter parm = method.getParameters().get(0);
        // sb.setLength(0);
        // sb.append(" * @param "); //$NON-NLS-1$
        // sb.append(parm.getName());
        // // sb.append(" the value for "); //$NON-NLS-1$
        // // sb.append(introspectedTable.getFullyQualifiedTable());
        // // sb.append('.');
        // // sb.append(introspectedColumn.getActualColumnName());
        // // sb.append(", ");
        // sb.append(" ");
        // sb.append(introspectedColumn.getRemarks());
        // method.addJavaDocLine(sb.toString());
        //
        // method.addJavaDocLine(" */"); //$NON-NLS-1$
    }

    @Override
    public void addComment(XmlElement xmlElement) {

        StringBuilder sb = new StringBuilder();

        xmlElement.addElement(new TextElement("<!--" + "@mbggenerated" + "-->"));

    }
}
