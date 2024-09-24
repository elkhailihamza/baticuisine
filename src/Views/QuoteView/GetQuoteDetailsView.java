package Views.QuoteView;

import Tools.GetValue;

public class GetQuoteDetailsView {
    public static long getQuoteId() {
        return GetValue.longValue(new String[]{"Enter quote id : "});
    }
}
