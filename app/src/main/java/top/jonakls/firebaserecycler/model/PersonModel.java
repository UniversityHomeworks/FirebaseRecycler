package top.jonakls.firebaserecycler.model;

import org.jetbrains.annotations.NotNull;

import java.util.UUID;

public class PersonModel {

    private final String id;
    private String name;
    private String email;
    private long phone;

    public PersonModel() {
        this.id = UUID.randomUUID().toString();
    }

    public PersonModel(
            final String id,
            final String name,
            final String email,
            final long phone
    ) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
    }

    public static PersonModel newPersonModel() {
        return new PersonModel();
    }

    public static PersonModel create(
            final String id,
            final String name,
            final String email,
            final long phone
    ) {
        return new PersonModel(id, name, email, phone);
    }

    @NotNull
    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public long getPhone() {
        return phone;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public void setEmail(final String email) {
        this.email = email;
    }

    public void setPhone(final long phone) {
        this.phone = phone;
    }
}
