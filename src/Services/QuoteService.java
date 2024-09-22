package Services;

import Models.Quotes;
import Repositories.GenericRepository;
import Repositories.QuoteRepository;

import java.util.List;

public class QuoteService {
    private final QuoteRepository quoteRepository;

    public QuoteService(QuoteRepository quoteRepository) {
        this.quoteRepository = quoteRepository;
    }

    public Quotes findById(long id) {
        return this.quoteRepository.findById(id);
    }

    public List<Quotes> fetchAll() {
        return this.quoteRepository.fetchAll();
    }

    public void save(Quotes entity) {
        this.quoteRepository.save(entity);
    }

    public void update(Quotes entity) {
        this.quoteRepository.update(entity);
    }

    public void delete(Quotes entity) {
        this.quoteRepository.delete(entity);
    }

    public boolean isAccepted(long id) {
        return this.findById(id).isAccepte();
    }
}
