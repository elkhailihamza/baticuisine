package Controllers;

import Models.Projets;
import Models.Quotes;
import Services.ProjetService;
import Services.QuoteService;
import Views.MainMenu;
import Views.QuoteView.GetQuoteDetailsView;
import Views.QuoteView.QuoteView;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

public class QuoteController extends Controller {
    private final QuoteService quoteService;
    private final ProjetService projetService;

    public QuoteController() {
        super();
        this.quoteService = repository.getQuoteService();
        this.projetService = repository.getProjetService();
    }

    public Quotes createNewQuote(Projets projet) {
        List<LocalDate> dates = QuoteView.registerQuotes();
        double montantEstime = projet.getCoutTotal();
        return new Quotes(1, montantEstime, dates.getFirst(), dates.getLast(), false, projet.getProjet_id());
    }

    public void viewAllQuotes() {
        this.showQuotes();
        this.quoteAccept();
    }

    public void showQuotes() {
        List<Quotes> quotes = this.quoteService.fetchAll();
        if (quotes.isEmpty()) {
            QuoteView.quoteNotFound();
        } else {
            quotes.forEach(q -> {
                Projets projet = this.projetService.findById(q.getProjectId());
                QuoteView.displayQuote(q, projet);
            });
        }
    }

    public void quoteAccept() {
        if (QuoteView.askForAccept()) {
            while (true) {
                long value = GetQuoteDetailsView.getQuoteId();
                Quotes quote = this.quoteService.findById(value);
                if (Objects.isNull(quote)) {
                    QuoteView.quoteNotFound();
                    continue;
                }
                quote.setIsAccepte(true);
                this.quoteService.update(quote);
                break;
            }
        }
    }

    public void saveQuote(Quotes quote) {
        this.quoteService.save(quote);
    }
}
