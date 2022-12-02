import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ManagerTest {

    @Test
    public void someTicketsAreFound() {
        Repository repo = new Repository();
        Manager manager = new Manager(repo);

        Ticket ticket1 = new Ticket(1, 5000, "Msc", "SPb");
        Ticket ticket2 = new Ticket(2, 6000, "Msc", "SPb");
        Ticket ticket3 = new Ticket(3, 18000, "Barnaul", "SPb");
        Ticket ticket4 = new Ticket(4, 7000, "Msc", "SPb");
        Ticket ticket5 = new Ticket(5, 10000, "Sochi", "Msc");
        Ticket ticket6 = new Ticket(6, 8000, "Msc", "SPb");
        Ticket ticket7 = new Ticket(7, 4000, "Msc", "SPb");
        Ticket ticket8 = new Ticket(8, 5500, "Msc", "SPb");

        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);

        Ticket[] expected = {ticket7, ticket1, ticket8, ticket2, ticket4, ticket6};
        Ticket[] actual = manager.findAll("Msc", "SPb");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void oneTicketIsFound() {
        Repository repo = new Repository();
        Manager manager = new Manager(repo);

        Ticket ticket1 = new Ticket(1, 5000, "Msc", "GBR");
        Ticket ticket2 = new Ticket(2, 6000, "SPb", "Msc");
        Ticket ticket3 = new Ticket(3, 18000, "Barnaul", "SPb");
        Ticket ticket4 = new Ticket(4, 7000, "Msc", "SPb");
        Ticket ticket5 = new Ticket(5, 10000, "Sochi", "Msc");


        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);


        Ticket[] expected = {ticket4};
        Ticket[] actual = manager.findAll("Msc", "SPb");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void noTicketsAreFound() {
        Repository repo = new Repository();
        Manager manager = new Manager(repo);

        Ticket ticket1 = new Ticket(1, 5000, "Msc", "Spb");
        Ticket ticket2 = new Ticket(2, 6000, "Msc", "GBR");
        Ticket ticket3 = new Ticket(3, 18000, "Barnaul", "SPb");
        Ticket ticket4 = new Ticket(4, 7000, "GBR", "SPb");
        Ticket ticket5 = new Ticket(5, 10000, "Sochi", "Msc");
        Ticket ticket6 = new Ticket(6, 8000, "Msc", "NYC");
        Ticket ticket7 = new Ticket(7, 4000, "Msc", "FIN");

        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);


        Ticket[] expected = {};
        Ticket[] actual = manager.findAll("Msc", "SPb");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void ticketsPriceIsDescended() {
        Repository repo = new Repository();
        Manager manager = new Manager(repo);

        Ticket ticket1 = new Ticket(1, 8000, "Msc", "SPb");
        Ticket ticket2 = new Ticket(2, 7000, "Msc", "SPb");
        Ticket ticket3 = new Ticket(3, 6000, "Msc", "SPb");
        Ticket ticket4 = new Ticket(4, 5000, "Msc", "SPb");


        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);

        Ticket[] expected = {ticket4, ticket3, ticket2, ticket1};
        Ticket[] actual = manager.findAll("Msc", "SPb");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void theSamePrice() {
        Repository repo = new Repository();
        Manager manager = new Manager(repo);

        Ticket ticket1 = new Ticket(1, 8000, "Msc", "SPb");
        Ticket ticket2 = new Ticket(2, 8000, "Msc", "SPb");
        Ticket ticket3 = new Ticket(3, 6000, "Msc", "SPb");
        Ticket ticket4 = new Ticket(4, 5000, "Msc", "SPb");


        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);

        Ticket[] expected = {ticket4, ticket3, ticket1, ticket2};
        Ticket[] actual = manager.findAll("Msc", "SPb");

        Assertions.assertArrayEquals(expected, actual);
    }
}