import java.util.Arrays;

public class Manager {
    private Repository repository;

    public Manager(Repository tickets) {
        this.repository = tickets;
    }

    public void add(Ticket ticket) {
        repository.save(ticket);
    }

    public Ticket[] findAll(String from, String to) {
        Ticket[] result = new Ticket[0];
        for (Ticket product : repository.findAll()) {
            if (matches(product, from, to)) {
                Ticket[] tmp = new Ticket[result.length + 1];
                for (int i = 0; i < result.length; i++) {
                    tmp[i] = result[i];
                }
                tmp[tmp.length - 1] = product;
                result = tmp;
            }
        }
        Arrays.sort(result);
        return result;
    }

    public boolean matches(Ticket product, String from, String to) {
        if (!product.getFrom().equals(from)) {
            return false;
        }
        if (!product.getTo().equals(to)) {
            return false;
        }
        return true;
    }
}