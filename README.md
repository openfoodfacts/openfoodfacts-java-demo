## Demo application using [Java Wrapper for OpenFoodFacts](https://github.com/openfoodfacts/openfoodfacts-java)

### How to use

Add one dependency to your POM file - check the current version [here](https://github.com/openfoodfacts/openfoodfacts-java)

```xml
<dependencies>
    <dependency>
        <groupId>pl.coderion</groupId>
        <artifactId>openfoodfacts-java-wrapper</artifactId>
        <version>0.9.3</version>
    </dependency>
</dependencies>
```

Create wrapper object

```javascript
OpenFoodFactsWrapper wrapper = new OpenFoodFactsWrapperImpl();
ProductResponse productResponse = wrapper.fetchProductByCode("737628064502");
```
