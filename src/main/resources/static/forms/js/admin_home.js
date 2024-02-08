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
        var idx = $('.ingredient-row').length
        $('#ingredientDiv').append(
            '<div class="ingredient-row">' +
            '<input type="text" th:required="true" th:field="*{ingredients[' + idx +']}" name="ingredients[' + index + '].key" placeholder="name ' + index + '"/>' +
            '<input type="text" th:required="true" th:field="*{ingredients[' + idx +']}" name="ingredients[' + index + '].value" placeholder="qty ' + index + '"/>' +
            '</div>'
        );
    });

    $('#addNutritionalContentBtn').click(function() {
        var index = $('.nutritional-content-row').length + 1;
        var idx = $('.nutritional-content-row').length
        $('#nutritionalContentFields').append(
            '<div class="nutritional-content-row">' +
            '<input type="text" th:required="true" th:field="*{nutritionalContents[' + idx +']}" name="nutritionalContents[' + index + '].key" placeholder="Content ' + index + '"/>' +
            '<input type="text" th:required="true" th:field="*{nutritionalContents[' + idx +']}" name="nutritionalContents[' + index + '].value" placeholder="Value ' + index + '"/>' +
            '</div>'
        );
    });
});