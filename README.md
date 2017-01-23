# mybatis-generator-core-fix 分支：branches-swagger
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
    
     /**
     * 获取  字段:tb_user.id
     *
     * @return tb_user.id, 
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置  字段:tb_user.id
     *
     * @param id the value for tb_user.id, 
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取 用户名 字段:tb_user.username
     *
     * @return tb_user.username, 用户名
     */
    public String getUsername() {
        return username;
    }

    /**
     * 设置 用户名 字段:tb_user.username
     *
     * @param username the value for tb_user.username, 用户名
     */
    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    /**
     * 获取 密码，加密存储 字段:tb_user.password
     *
     * @return tb_user.password, 密码，加密存储
     */
    public String getPassword() {
        return password;
    }

    /**
     * 设置 密码，加密存储 字段:tb_user.password
     *
     * @param password the value for tb_user.password, 密码，加密存储
     */
    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }


}

```
