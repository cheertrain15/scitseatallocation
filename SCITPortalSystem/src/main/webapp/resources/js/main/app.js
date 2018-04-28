$(document).ready(function () {
    /*
     * toggle mobile menu
     */
    $(".show-nav").click(function(e) {
        e.stopPropagation();
        $("#nav-toggle").toggle();
    });
    
    /*
     * hide expertise list beyond three item
     */
    
    /*$('ul.expertise').each(function(index) {
        var $item = $(this).find('li');
        var $total = $item.size();
        if($total > 2) {
          $(this).addClass('expertise--more');
          $(this).after('<div class="more"></div>');
        }
    });*/
    
    $('.person--text').each(function(index) {
        var $high = $(this).outerHeight();
        var $default = 400;
        if($high > $default) {
            $(this).addClass('person--text-more');
            $(this).after('<div class="more"></div>');
        }
    });
      
    $('.more').on('click', function(e) {
        $(this).prev().toggleClass('active');
        e.preventDefault();
    });
    
    /* parallax article images */
    function parallaxImage($imgContainer) {
        // more easing math function - https://gist.github.com/gre/1650294
        function easing(t)  { return t<.5 ? 4*t*t*t : (t-1)*(2*t-2)*(2*t-2)+1 }
        $imgContainer.each(function () {
            var $img = $("img", this);
            function adjustImageMargin() {
                var boundingBox = $imgContainer[0].getBoundingClientRect();
                var imageOffset = $img.height() - $imgContainer.height();
                var scrollPercent = window.scrollY / (window.scrollY + boundingBox.bottom);
                if (scrollPercent > 1) {scrollPercent = 1;}
                var margin = imageOffset * easing(scrollPercent);
                $img.css("margin-top", -margin)
            }
            adjustImageMargin();
            $(window).scroll(adjustImageMargin);
            $(window).resize(adjustImageMargin);
        });
    }
      
    var $featuredImageWrap = $(".feature-img");
    parallaxImage($featuredImageWrap);
      
    // add loaded class when image is ready
    $featuredImageWrap.each(function(){
        var $img = $("img", this).load(function(){
          $featuredImageWrap.addClass("loaded");
        });
        if($img[0] && $img[0].complete){
          $featuredImageWrap.addClass("loaded");
        }
    });

    /*
     Accordion
     */
    var $el = $(".accordion__list");
    var $titles = $el.find('> dt');
    var $content = $el.find('> dd');

    // Set up click handler
    $(".accordion__list > dt").on('click', function (e) {
        e.preventDefault();
        handleToggle($(this));
    });

    // Set up accessibility
    $(".accordion__list").on('keydown', function keydown(e) {
        var $this = $(e.target);
        var test = '';

        if ($this.parent('.accordion__list').length) {

            switch (e.which) {
                case 13:
                // enter
                case 32:
                    // spacebar
                    e.preventDefault();
                    handleToggle($this);
                    break;
                case 38:
                    // up arrow
                    if (test = $this.prevAll('dt:first')) {
                        e.preventDefault();
                        test.focus();
                    }
                    break;
                case 40:
                    // down arrow
                    if (test = $this.nextAll('dt:first')) {
                        e.preventDefault();
                        test.focus();
                    }
                    break;
                case 27:
                    // escape
                    $this.blur();
                    break;
            }
        }
    });

// Provide some defaults we can reuse
    var ariaAttr = {
        hideTitle: {
            'aria-selected': 'false'
        },
        showTitle: {
            'aria-selected': 'true'
        },
        hidePanel: {
            'aria-expanded': 'false',
            'aria-hidden': 'true'
        },
        showPanel: {
            'aria-expanded': 'true',
            'aria-hidden': 'false'
        }
    }

    // Add IDs and Aria attributes
    $.each($titles, function (titleID, value) {
        $(this).attr({
            'id': 'title-' + titleID,
            'aria-controls': 'panel-' + titleID
        });
    })

    $.each($content, function (contentID, value) {
        $(this).attr({
            'id': 'panel-' + contentID,
            'aria-labelledby': 'title-' + contentID
        });
    });

    // Add aria roles for items to be hidden
    $titles.attr(ariaAttr.hideTitle);
    $content.attr(ariaAttr.hidePanel);

    function handleToggle(header) {
        var accordion = header.parent('dl');
        // Close all open accordion items
        accordion.children("dd:visible").slideUp({
            start: function () {
                header.siblings('dt').removeClass('open');
                header.removeClass('open');
                // Set the aria attributes on other headers
                accordion.find('dt').attr(ariaAttr.hideTitle);
                accordion.find('dd').attr(ariaAttr.hidePanel);
            }
        });

        // Open this accordion item
        header.next('dd').filter(':not(:visible)').slideDown({
            start: function () {
                header.addClass('open');
                var $this = $(this);
                var titleId = $this.attr('aria-labelledby');
                $('#' + titleId).attr(ariaAttr.showTitle);
                $this.attr(ariaAttr.showPanel);
            }
        });

    }
    $(".accordion__list dt.open").click();
});

IUSearch && IUSearch.init({
    CX: {
        site: '002940456505989808637:m8fmour1rb4', // Replace this with site CX value
        all: '016278320858612601979:ddl1l9og1w8'// Replace this with campus CX value
    },
    attributes: {
        resultsUrl: 'https://itnews.iu.edu/search/'
    }
});