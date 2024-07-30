import java.time.LocalTime;

public class Park {
    private String name;
    private Attraction[] attractions;
    private String address;

    public Park(String name, Attraction[] attractions, String address) {
        this.name = name;
        this.attractions = attractions;
        this.address = address;
    }

    public class Attraction {
        private String name;
        private LocalTime openingTime;
        private LocalTime closingTime;
        private int price;

        public Attraction(String name, LocalTime openingTime, LocalTime closingTime, int price) {
            this.name = name;
            this.openingTime = openingTime;
            this.closingTime = closingTime;
            this.price = price;
        }
    }
}
