package in.springrest.Springrestapi.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.validation.annotation.Validated;

import java.util.Date;

@Setter
@Getter
@ToString
@Entity
@Validated
@Table(name = "Employee_Table")
public class EmployeeModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;
    //@JsonProperty("full_name") -> Alias name which will map to name
    //@NotNull(message = "Name should not be null") -> field should not be null but "" will work
    //@NotEmpty(message = "Name should not be empty") -> field should not be empty but "  " will work
    @NotBlank(message = "Name is mandatory")
    @Column(name = "name")
    private String name;
    //@JsonIgnore -> we can hide sensitive field
    @Column(name = "age")
    private long age;
    @Email(message = "Enter the valid email id")
    @Column(name = "email")
    private String email;
    @NotNull(message = "Location should not be null")
    @Column(name = "location")
    private String location;
    @Column(name = "department")
    private String department;
    @CreationTimestamp
    @Column(name = "Created_at", nullable = false, updatable = false)
    private Date createdAt;
    @UpdateTimestamp
    @Column(name = "Updated_at")
    private Date updatedAt;

    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }
}
