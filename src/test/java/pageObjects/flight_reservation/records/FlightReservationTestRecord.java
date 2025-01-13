package pageObjects.flight_reservation.records;

public record FlightReservationTestRecord(String firstName,
                                          String lastName,
                                          String email,
                                          String password,
                                          String street,
                                          String city,
                                          String state,
                                          String zip,
                                          String passengers,
                                          String serviceClass,
                                          String totalPrice) {
}
