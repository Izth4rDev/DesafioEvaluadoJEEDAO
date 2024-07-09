package models;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class UserProviderDTO {
    private int idProvider;
    private String name;
    private String rut;
    private String address;
    private String mail;
    private String phoneNumber;
    private String contact;
    private String contactNumber;
}
