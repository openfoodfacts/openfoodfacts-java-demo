import pl.coderion.model.Ingredient;
import pl.coderion.model.Nutriments;
import pl.coderion.model.Product;
import pl.coderion.model.ProductResponse;
import pl.coderion.model.SelectedImages;
import pl.coderion.service.OpenFoodFactsWrapper;
import pl.coderion.service.impl.OpenFoodFactsWrapperImpl;

public class Application {

  public static void main(String[] args) {
    OpenFoodFactsWrapper wrapper = new OpenFoodFactsWrapperImpl();
    ProductResponse productResponse = wrapper.fetchProductByCode("737628064502");

    if (!productResponse.isStatus()) {
      System.out.println("Status: " + productResponse.getStatusVerbose());
      return;
    }

    Product product = productResponse.getProduct();

    System.out.println("Name: " + product.getProductName());
    System.out.println("Generic name: " + product.getGenericName());
    System.out.println("Product code: " + product.getCode());

    System.out.println("=== Ingredients ===");
    for (Ingredient ingredient : product.getIngredients()) {
      System.out.println(" * " + ingredient.getText());
    }

    System.out.println("=== Nutriments ===");
    Nutriments nutriments = product.getNutriments();
    if (nutriments != null) {
      System.out.println(
          String.format(
              " * Calcium=%s%s", nutriments.getCalciumValue(), nutriments.getCalciumUnit()));
      System.out.println(
          String.format(" * Sugars=%s%s", nutriments.getSugarsValue(), nutriments.getSugarsUnit()));
      System.out.println(String.format(" * Energy=%skcal", nutriments.getEnergyKcal()));
    }

    System.out.println("=== Images ===");
    SelectedImages selectedImages = product.getSelectedImages();
    if (selectedImages != null) {
      System.out.println(" * Front: " + selectedImages.getFront().getDisplay().getUrl());
      System.out.println(
          " * Ingredients: " + selectedImages.getIngredients().getDisplay().getUrl());
      System.out.println(" * Nutrition: " + selectedImages.getNutrition().getDisplay().getUrl());
    }

    System.out.println(
        "\n\nFor additional data go to model definition: "
            + "https://github.com/openfoodfacts/openfoodfacts-java/blob/main/src/main/java/pl/coderion/model/Product.java");
  }
}
