package customer;

import persistence.EntityAlreadyExistsException;

public class RegisterCustomerService {
    private final CustomerDao repo;

    public RegisterCustomerService(CustomerDao repo) {
        this.repo = repo;
    }

    public void register(String plate, String phone, VehicleType vehicleType) {
        if (plate == null || phone == null || vehicleType == null)
            throw new IllegalArgumentException("Plate, phone and vehicle type must not be null.");
        if (repo.findOne(plate).isPresent())
            throw new EntityAlreadyExistsException("Customer with plate " + plate + " already exists.");

        repo.save(new CustomerDto(
                plate,
                phone,
                vehicleType.toString()
        ));
    }

}
