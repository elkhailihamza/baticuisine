package Views.QuoteView;

import Views.View;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class QuoteView extends View {
    public static List<LocalDate> registerQuotes() {
        List<LocalDate> dates;
        LocalDate startDate;
        LocalDate endDate;
        String pattern = "dd/MM/yyyy";
        header("--- Enregistrement du Devis ---");
        do {
            dates = new ArrayList<>();

            startDate = getLocalDateValue(new String[]{"Entrez la date d'émission du devis (format : jj/mm/aaaa) :"}, pattern);
            dates.add(startDate);

            endDate = getLocalDateValue(new String[]{"Entrez la date de validité du devis (format : jj/mm/aaaa) :"}, pattern);
            dates.add(endDate);
        } while (!checkIfInputIsY());
        header("Devis enregistré avec succès !");
        return dates;
    }

    public static void saveSuccessful() {
        header("Devis enregistré avec succès !");
    }
}
