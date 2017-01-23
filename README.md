# mybatis-generator-core-fix 分支：branch-swagger
mybatis generator 生成数据库备注为注释，并整合swagger进行在线API管理，解放文档的编写
本工程为maven项目，可以直接打包使用

生成后的样式：
```

@ApiModel(value="用户表",description="数据库表：tb_user")
public class TbUser {

    @ApiModelProperty(value="id",name="id", required=true)
    @NotEmpty
    private Long id;

    @ApiModelProperty(value="用户名",name="username", required=true)
    @NotEmpty
    private String username;

    @ApiModelProperty(value="密码，加密存储",name="password", required=true)
    @NotEmpty
    private String password;

}

```
