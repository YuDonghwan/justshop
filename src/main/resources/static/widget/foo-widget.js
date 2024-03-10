//
// Define widget example.foo (derives directly from $.Widget)
//

var debug = $.proxy(window.console, 'debug')

$.widget('test.ex', {

    options: {
        bgcolor: '#efefef',
        description: 'A wonderfull widget',
    },

    // Constructor
    _create: function() {
        debugger;
        this.element.addClass('foo-widget')
        this.element.find('button').button()
        this._setupEvents()
        this._refresh();
        debug(this.widgetFullName + ': '
            + 'Created a widget (' + this.options.description + ')')
    },

    // Render when created (or later when changing options)
    _refresh: function()
    {
        this.element.find('input').css('background-color', this.options.bgcolor)
    },

    // Destructor: revert changes made on this element
    // Note: callbacks registered via _on are removed automatically
    _destroy: function()
    {
        this.element.find('button').button('destroy')
        this.element.find('input').css('background-color', 'inherit')
        this.element.removeClass('foo-widget')
        debug(this.widgetFullName + ': '
            + 'Destroyed a widget (' + this.options.description + ')')
    },

    // Configure with a dict of options 
    _setOptions: function()
    {
        // Note: _super and _superApply handle keeping the right this-context
        this._superApply(arguments);
        // Note: always refresh when changing options
        this._refresh();
    },

    // Configure for each individual option
    _setOption: function(key, value)
    {
        this._super(key, value);
    },

    //
    // Custom exposed methods
    //

    // Provide (and expose) a widget method
    baz: function (opts)
    {
        debug(this.widgetFullName + ': baz!!')
    },

    //
    // Base implementation
    //

    _setupEvents: function ()
    {
        this._on(this.element, {
            // The callbacks registered via _on will maintain `this` 
            'change input': this._handleChanged,
        })
    },

    //
    // Internal callbacks
    //

    // Callback when input has changed 
    _handleChanged: function (ev)
    {
        var $input = $(ev.target)
        debug(this.widgetFullName + ': The input changed: ' + $input.val())
    },
})