$(document).ready(function() {
    $('#addDirectionBtn').click(function() {
        var index = $('.direction-row').length + 1;
        $('#directionFields').append(
            '<div class="direction-row">' +
            '<input type="text" name="directions[' + index + ']" placeholder="Direction ' + index + '" />' +
            '</div>'
        );
    });

    $('#addIngredientBtn').click(function() {
        var index = $('.ingredient-row').length + 1;
        $('#ingredientFields').append(
            '<div class="ingredient-row">' +
            '<input type="text" name="ingredients[' + index + '].key" placeholder="Ingredient" />' +
            '<input type="text" name="ingredients[' + index + '].value" placeholder="Quantity" />' +
            '</div>'
        );
    });

    $('#addNutritionalContentBtn').click(function() {
        var index = $('.nutritional-content-row').length + 1;
        $('#nutritionalContentFields').append(
            '<div class="nutritional-content-row">' +
            '<input type="text" name="nutritionalContent[' + index + '].key" placeholder="Nutrient" />' +
            '<input type="text" name="nutritionalContent[' + index + '].value" placeholder="Value" />' +
            '</div>'
        );
    });
});
