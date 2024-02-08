    $('#addDirectionBtn').click(function() {
        var index = 1;
        $('#directionFields').append(
            '<div class="direction-row">' +
            '<input type="text" name="directions[' + index + ']" placeholder="Direction ' + index + '" />' +
            '</div>'
        );
        index++;
    });

     $('#addCategoryBtn').click(function() {
            var index = 1;
            $('#categoryFields').append(
                '<div class="category-row">' +
                '<input type="text" name="categories[' + index + ']" placeholder="Category ' + index + '" />' +
                '</div>'
            );
            index++;
        });

    $('#addIngredientBtn').click(function() {
        var index = 1;
        $('#ingredientDiv').append(
            '<div class="ingredient-row">' +
            '<input type="text" name="ingredients[' + index + '].key" placeholder="name ' + index + '"/>' +
            '<input type="text" name="ingredients[' + index + '].value" placeholder="qty ' + index + '"/>' +
            '</div>'
        );
        index++;
    });

    $('#addNutritionalContentBtn').click(function() {
        var index = 1;
        $('#nutritionalContentFields').append(
            '<div class="nutritional-content-row">' +
            '<input type="text" name="nutritionalContents[' + index + '].key" placeholder="Content ' + index + '"/>' +
            '<input type="text" name="nutritionalContents[' + index + '].value" placeholder="Value ' + index + '"/>' +
            '</div>'
        );
        index++;
    });
