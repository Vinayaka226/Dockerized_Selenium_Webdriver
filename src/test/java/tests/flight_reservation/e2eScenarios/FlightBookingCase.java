package tests.flight_reservation.e2eScenarios;

import pageObjects.flight_reservation.agent.*;
import pageObjects.flight_reservation.records.FlightReservationTestRecord;
import util.JSONUtil;

import java.util.function.Consumer;

public class FlightBookingCase {

    private static final String testDataPath = "test-data/flight-reservation/";
    private static final String testDataSinglePassengerFileName = "singlePassenger.json";
    private static final String testDataTwoPassengerFileName = "TwoPassengers.json";
    private static final FlightReservationTestRecord testDataSinglePassenger = JSONUtil.getData(testDataPath+testDataSinglePassengerFileName, FlightReservationTestRecord.class);
    private static final FlightReservationTestRecord testDataTwoPassenger = JSONUtil.getData(testDataPath+testDataTwoPassengerFileName, FlightReservationTestRecord.class);

    // Behaviour On Page for Single Passenger > One Way Ticket
    public static final Consumer<CustomerRegistrationPage> custRegSinglePassenger = (reg) -> reg.enterFirstName(testDataSinglePassenger.firstName())
                                                                        .enterLastName(testDataSinglePassenger.lastName())
                                                                        .enterZip(testDataSinglePassenger.zip())
                                                                        .enterCity(testDataSinglePassenger.city())
                                                                        .selectState(testDataSinglePassenger.state())
                                                                        .clickRegisterButton()
                                                                        .assertDisplayedFirstName(testDataSinglePassenger.firstName())
                                                                        .clickGoToFlightSearch()
                                                                        .selectOnewayTrip()
                                                                        .selectPassengers(testDataSinglePassenger.passengers())
                                                                        .selectServiceClass(testDataSinglePassenger.serviceClass())
                                                                        .clickFlightSearchButton()
                                                                        .clickDepartureEmiratesFirst()
                                                                        .clickConfirmFlight()
                                                                        .assertTotalPrice(testDataSinglePassenger.totalPrice());

    public static final Consumer<CustomerRegistrationPage> custRegTwoPassengers = (reg) -> reg.enterFirstName(testDataTwoPassenger.firstName())
                                                                        .enterLastName(testDataTwoPassenger.lastName())
                                                                        .enterZip(testDataTwoPassenger.zip())
                                                                        .enterCity(testDataTwoPassenger.city())
                                                                        .selectState(testDataTwoPassenger.state())
                                                                        .clickRegisterButton()
                                                                        .assertDisplayedFirstName(testDataTwoPassenger.firstName())
                                                                        .clickGoToFlightSearch()
                                                                        .selectOnewayTrip()
                                                                        .selectPassengers(testDataTwoPassenger.passengers())
                                                                        .selectServiceClass(testDataTwoPassenger.serviceClass())
                                                                        .clickFlightSearchButton()
                                                                        .clickDepartureEmiratesFirst()
                                                                        .clickConfirmFlight()
                                                                        .assertTotalPrice(testDataTwoPassenger.totalPrice());


}
