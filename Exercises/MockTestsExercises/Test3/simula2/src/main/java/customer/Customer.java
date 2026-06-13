package customer;

import java.util.Objects;

public class Customer {
    private final String plate;
    private String phone;
    private VehicleType type;

    public Customer(String plate, String phone, VehicleType type) {
        this.plate = plate;
        this.phone = phone;
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return Objects.equals(plate, customer.plate) && Objects.equals(phone, customer.phone) && type == customer.type;
    }

    @Override
    public int hashCode() {
        return Objects.hash(plate, phone, type);
    }

    @Override
    public String toString() {
        return "Customer{" +
                "plate='" + plate + '\'' +
                ", phone='" + phone + '\'' +
                ", type=" + type +
                '}';
    }

    public String getPlate() {
        return plate;
    }

    public String getPhone() {
        return phone;
    }

    public VehicleType getType() {
        return type;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setType(VehicleType type) {
        this.type = type;
    }
}
