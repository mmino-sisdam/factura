// Template Settings for Underscore
// Change <% %> for <@ @>

  _.templateSettings = {
    evaluate    : /<@([\s\S]+?)@>/g,
    interpolate : /<@=([\s\S]+?)@>/g,
    escape      : /<@-([\s\S]+?)@>/g
  };

// Variables globales
/* ------------------------------ */

PATH_LAYOUT = $('#layout');
MODAL_LAYOUT = $('#layout-modal');




/*
tpl = {

    // Hash of preloaded templates for the app
    templates: {},

    // Recursively pre-load all the templates for the app.
    // This implementation should be changed in a production environment. All the template files should be
    // concatenated in a single file.
    loadTemplates: function(names, callback) {

        var that = this;

        var loadTemplate = function(index) {
            var name = names[index];
            console.log('Loading template: ' + name);
            $.get('resurces/includes/' + name + '.html', function(data) {
                that.templates[name] = data;
                index++;
                if (index < names.length) {
                    loadTemplate(index);
                } else {
                    callback();
                }
            });
        }

        loadTemplate(0);
    },

    // Get template by name from hash of preloaded templates
    get: function(name) {
        return this.templates[name];
    }

};


(function($){
	$.fn.serializeObject = function () {
		"use strict";

		var result = {};
		var extend = function (i, element) {
			var node = result[element.name];

	// If node with same name exists already, need to convert it to an array as it
	// is a multi-value field (i.e., checkboxes)

			if ('undefined' !== typeof node && node !== null) {
				if ($.isArray(node)) {
					node.push(element.value);
				} else {
					result[element.name] = [node, element.value];
				}
			} else {
				result[element.name] = element.value;
			}
		};

		$.each(this.serializeArray(), extend);
		return result;
	};
})(jQuery);
*/
