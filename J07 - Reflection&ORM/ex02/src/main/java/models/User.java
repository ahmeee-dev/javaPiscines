package models;

import annotations.OrmColumn;
import annotations.OrmColumnId;
import annotations.OrmEntity;

@OrmEntity(table = "simple_user")
public class User {
@OrmColumnId
private Long id;
@OrmColumn(name = "first_name", length = 10)
private String firstName;
@OrmColumn(name = "first_name", length = 10)
private String lastName;
@OrmColumn(name = "age")
private Integer age;
// setters /getters
}
