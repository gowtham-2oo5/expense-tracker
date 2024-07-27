package com.beans;

import java.io.InputStream;
import javax.faces.bean.ManagedBean;
import javax.servlet.http.Part;
import com.entities.User;
import com.entities.UserType;
import com.services.UserServices; // Assuming there's a UserServices class

@ManagedBean(name = "newUser", eager = true)
public class NewUserBean {

    // Fields
    private String name;
    private String uname;
    private String mail;
    private String phone;
    private String password;
    private String role; // Added for the working role dropdown
    private Part dp;

    // Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Part getDp() {
        return dp;
    }

    public void setDp(Part dp) {
        this.dp = dp;
    }

    // Method to handle form submission
    public void submit() {
        if (dp != null) {
            try (InputStream inputStream = dp.getInputStream()) {
                byte[] imageBytes = new byte[(int) dp.getSize()];
                inputStream.read(imageBytes);

                User newUser = new User();
                newUser.setEmail(mail);
                newUser.setName(name);
                newUser.setUsername(uname);
                newUser.setPassword(password);
                newUser.setPhone(phone);
                newUser.setProfilePicture(imageBytes);
                newUser.setUserType(UserType.BASIC); // Set user type based on role
                newUser.setWorkRole(role);
                newUser.setStatus(false);

                UserServices userServices = new UserServices();
                userServices.addUser(newUser);

                System.out.println("Inserted successfully");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
