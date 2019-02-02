package org.allen.demo.entity;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.*;

/**
 * @author wl
 * @version V1.0
 * @Description TODO
 * @date 2019-01-21 15:44
 */
public class Person {

    private Integer id;

    @NotBlank(message = "不能为空")
    @Length(min = 2, max = 20, message = "长度要在2到20之间")
    private String name;

    @NotNull
    @Min(value = 17, message = "最小值为17")
    private Integer age;

    @NotEmpty
    @Email(message="邮件格式不正确")
    private String email;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
