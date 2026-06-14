package customer;

public class CustomerMapper {
    public static Customer toEntity(CustomerDto customerDto) {
        return new Customer(customerDto.plate(), customerDto.phone(), VehicleType.valueOf(customerDto.type()));
    }
}
