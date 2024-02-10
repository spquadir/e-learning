   $(document).ready(function() {
    $('#addDirectionBtn').click(function() {
        var index = $('.direction-row').length + 1;
        $('#directionFields').append(
            '<div class="direction-row">' +
            '<input type="text" name="directions[' + index + ']" placeholder="Direction ' + index + '" />' +
            '</div>'
        );
    });

     $('#addCategoryBtn').click(function() {
         var index = $('.category-row').length + 1;
         $('#categoryFields').append(
                '<div class="category-row">' +
                '<input type="text" name="categories[' + index + ']" placeholder="Category ' + index + '" />' +
                '</div>'
            );
        });

    $('#addIngredientBtn').click(function() {
        var index = $('.ingredient-row').length + 1;
        var keyId = "key_ingredient_" + index;
        var valueId = "value_ingredient_" +index;
        $('#ingredientDiv').append(
            '<div class="ingredient-row">' +
            '<input type="text" id='+keyId+' th:required="true" th:field="*{ingredients[key' + index +']}" name="ingredients[' + keyId + ']" placeholder="name ' + index + '"/>' +
            '<input type="text" id='+valueId+' th:required="true" th:field="*{ingredients[value' + index +']}" name="ingredients[' + valueId + ']" placeholder="qty ' + index + '"/>' +
            '</div>'
        );
    });


    $('#addNutritionalContentBtn').click(function() {
        var index = $('.nutritional-content-row').length + 1;
        var keyId = "key_nutrition_" + index;
        var valueId = "value_nutrition_" +index;
        $('#nutritionalContentFields').append(
            '<div class="nutritional-content-row">' +
            '<input type="text" id='+keyId+' th:required="true" th:field="*{nutritionalContents[key' + index +']}" name="nutritionalContents[' + keyId + ']" placeholder="name ' + index + '"/>' +
            '<input type="text" id='+valueId+' th:required="true" th:field="*{nutritionalContents[value' + index +']}" name="nutritionalContents[' + valueId + ']" placeholder="value ' + index + '"/>' +
            '</div>'
        );
    });
});