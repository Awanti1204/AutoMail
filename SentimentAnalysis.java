import opennlp.tools.doccat.DoccatModel;
import opennlp.tools.doccat.DocumentCategorizerME;

public class SentimentAnalysis {
    private DoccatModel model;

    public SentimentAnalysis(DoccatModel model) {
        this.model = model;
    }

    public String classifySentiment(String text) throws Exception {
        DocumentCategorizerME categorizer = new DocumentCategorizerME(model);
        double[] outcomes = categorizer.categorize(text);
        return categorizer.getBestCategory(outcomes);
    }
}
