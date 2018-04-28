/*
 * jQuery throttle / debounce - v1.1 - 3/7/2010
 * http://benalman.com/projects/jquery-throttle-debounce-plugin/
 * 
 * Copyright (c) 2010 "Cowboy" Ben Alman
 * Dual licensed under the MIT and GPL licenses.
 * http://benalman.com/about/license/
 */
(function(b,c){var $=b.jQuery||b.Cowboy||(b.Cowboy={}),a;$.throttle=a=function(e,f,j,i){var h,d=0;if(typeof f!=="boolean"){i=j;j=f;f=c}function g(){var o=this,m=+new Date()-d,n=arguments;function l(){d=+new Date();j.apply(o,n)}function k(){h=c}if(i&&!h){l()}h&&clearTimeout(h);if(i===c&&m>e){l()}else{if(f!==true){h=setTimeout(i?k:l,i===c?e-m:e)}}}if($.guid){g.guid=j.guid=j.guid||$.guid++}return g};$.debounce=function(d,e,f){return f===c?a(d,e,false):a(d,f,e!==false)}})(this);

// UITS
$(document).ready(function () {
    var $supportSelect = $('select.select-campus-support');
    var urlUitsRoot = 'https://uits.iu.edu';
    var $navQuicklinks = $(".nav-dropdown--quicklinks");
    var $navNotices = $(".nav-dropdown--notices");
    var $navSupport = $(".nav-dropdown--support");
    var $ipDropdown = $(".ip-dropdown").click(function (e) {
        e.stopPropagation();
    });
    var $body = $("body");
    var windowWidth = $(window).width();
    var $brandingBar = $('#branding-bar-v1');
    var $support = $(".js-support");
    var $notices = $(".js-notices");
    var $services = $(".js-services");

    // clicking anywhere in the document will close ip-dropdown
    $(document).click(function () {
        $ipDropdown.hide();
        if ($body.hasClass("notices-open")) {
            toggleNotices();
        }
        if ($body.hasClass("support-open")) {
            toggleSupport();
        }
        if ($body.hasClass("quicklinks-open")) {
            toggleQuicklinks();
        }
    });

    if (windowWidth < 881) {
        $("section.featured-services").before($("section.alerts"));
    } else {
        $brandingBar.before($("section.alerts"));
    }

    // fix windows phone margin issue
    if ($('body.home').length && (navigator.userAgent.match(/Windows Phone/i) || navigator.userAgent.match(/MSIE/i))) {
        $brandingBar.find('.unit:not(.main-nav)').css("margin-bottom", "-3em");
    }


    /*****************
     * Subsite navigation for mobile (uses <select>)
     *****************/
    $(".js-select-nav").change(function () {
        window.location.href = $(this).val();
    });


    /*****************
     * Expandable search gets wider and nudge moves over
     * triggered by focus on .js-expandable-search__trigger, or children of .js-expandable-search__hold
     *****************/
    $(document).on('focus', ".js-expandable-search__trigger, .js-expandable-search__hold *", function () {
        $(".js-expandable-search").addClass("is-expanded");
        $(".js-expandable-search__nudge").addClass("is-nudged");
    });
    $(document).on('blur', ".js-expandable-search__trigger, .js-expandable-search__hold *", function () {
        $(".js-expandable-search").removeClass("is-expanded");
        $(".js-expandable-search__nudge").removeClass("is-nudged");
    });


    //add .is-locked-open on touch start inside of .js-search-tips to allow touch users to interact with dropdown
    //(otherwise the above blur event is fired, and because touch devices don't appear to focus on tapped elements, .is-open is removed)
    $(document).on("touchstart", ".js-search-tips", function (e) {
        e.stopPropagation();
        $(".js-search-tips").addClass("is-locked-open");
    });
    //remove .is-locked-open on click outside of .js-search-tips
    //(touch starts inside of .js-search-tips are not propagated)
    $(document).on("touchstart", function () {
        $(".js-search-tips").removeClass("is-locked-open");
    });
    

    /*****************
     * Accordions for mobile
     *****************/
    $("[data-macc-target]").addClass("macc-target");
    $("[data-macc-trigger]").addClass("macc-trigger").click(function () {
        var id = $(this).attr("data-macc-trigger");
        if ($(this).is(".open")) {
            $(this).removeClass("open");
            $("[data-macc-target=" + id + "]").removeClass("open");
        } else {
            $("[data-macc-target],[data-macc-trigger]").removeClass("open");
            $(this).addClass("open");
            $("[data-macc-target=" + id + "]").addClass("open");
        }
    });


    /*****************
     * uits mobile navigation
     *****************/
    $(".footer-uits-links a[href=#footer-menu]").click(function (e) {
        var $links = $(".footer-uits-links");
        e.preventDefault();
        if ($links.is(".open")) {
            $("ul", $links).slideUp(200);
            $links.removeClass("open");
        } else {
            $("ul", $links).slideDown(200);
            $links.addClass("open");
        }
    });

    /* stop propagation in nav-dropdown to avoid closing */
    $(".nav-dropdown").click(function (e) {
        e.stopPropagation();
    });


    /*****************
     * Campus selector script for Get Help fly out
     *****************/
    $supportSelect.change(function () {
        var option = $(this).find('option:selected');
        $(".support-info, .ip-dropdown").hide();
        $("." + this.value + "-support-info").show();
        $supportSelect.val(option.val());
    });

    // get campus
    $.getJSON(urlUitsRoot + '/api/campus.json?callback=?', function (campus) {
        $('option[value="' + campus + '"]', $supportSelect).attr('selected', 'selected');
        $supportSelect.change()
    }).fail(function(){
        console.log("Fail: " + urlUitsRoot + '/api/campus.json?callback=?');
    });

    $(window).resize(function () {
        var w = $(window).width();
        var h = $(window).height();
        $((w < 881) ? "section.featured-services" : "#branding-bar-v1").before($("section.alerts"));
        var viewHeight = (w < 642) ? (h - 48) + 'px' : 'inherit';
        $navQuicklinks.css("height", viewHeight);
        $navNotices.css("height", viewHeight);
        $navSupport.css("height", viewHeight);
    });
    
    /************************
     *     Search bar
     *************************/
    var timeout = false;
    var $search_container = $(".search");
    var $search_form = $(".search__form");
    var $input = $(".search__input");
    
    /************************
     *    Skip link
     * manually set focus to target of skip link
     *************************/
    $(".skip-link").click(function(e) {
        e.preventDefault();
        var href = $(this).attr("href");
        $(href).focus();
    });
    
    
    /************************
     *    Search form
     *************************/
    //display "press enter" as you type
    $input.on('input', function() {
        var q = this.value;
        if (q == '') {
            $search_form.removeClass("ready-to-search");
            clearTimeout(timeout);
        } else {
            if (timeout) {
                clearTimeout(timeout);
            }
            timeout = window.setTimeout(function() {
                $search_form.addClass("ready-to-search");
            }, 250);
        }
    });
    
    if ($(window).width() < 500) {
        $(".js-expand-placeholder").attr("placeholder", "Search for IT support at IU");
    }
    
    /*****************
     * Expandable search gets wider and nudge moves over
     * triggered by focus on .js-expandable-search__trigger, or children of .js-expandable-search__hold
     *****************/
    $(document).on('focus', ".js-expandable-search__trigger, .js-expandable-search__hold *", function() {
        $(".js-expandable-search").addClass("is-expanded");
        $(".js-expandable-search__nudge").addClass("is-nudged");
    });
    $(document).on('blur', ".js-expandable-search__trigger, .js-expandable-search__hold *", function() {
        $(".js-expandable-search").removeClass("is-expanded");
        $(".js-expandable-search__nudge").removeClass("is-nudged");
    });
    
    /*****************
     * Search dropdown
     *****************/
    //focus on .js-search-tips__trigger or any element inside of .js-search-tips applies .is-open to .js-search-tips
    //since focus() fires after blur(), moving from one of these elements to another effectively does nothing, leaving the dropdown open
    //(see http://stackoverflow.com/questions/20340091/is-it-guaranteed-that-blur-event-happens-before-the-focus-when-giving-focus)
    $(document).on('focus click', '*', function(e) {
        if ($(e.target).is(".js-search-tips,.js-search-tips__trigger") || $(e.target).parents(".js-search-tips,.js-search-tips__trigger").length) {
            $(".js-search-tips").addClass("is-open");
        } else {
            $(".js-search-tips").removeClass("is-open");
        }
    });
    
    //add .is-locked-open on touchstart inside of .js-search-tips to allow touch users to interact with dropdown
    //(otherwise the above blur event is fired, and because touch devices don't appear to focus on tapped elements, .is-open is removed)
    $(document).on("touchstart", ".js-search-tips", function(e) {
        e.stopPropagation();
        $(".js-search-tips").addClass("is-locked-open");
    });
    //remove .is-locked-open on click outside of .js-search-tips
    //(touchstarts inside of .js-search-tips are not propagated)
    $(document).on("touchstart", function(e) {
        $(".js-search-tips").removeClass("is-locked-open");
    });
    
    /* Search suggestions */
    var selectedURL = false;
    
    //handlers for up arrow, down arrow, and esc keys
    $input.keyup(function(e) {
        var code = e.keyCode || e.which;
    
        //down arrow
        if (code == '40') {
            e.preventDefault();
            if ($(".js-suggestions li").length) {
                if ($(".js-suggestions .is-selected").length) {
                    $current = $(".js-suggestions .is-selected");
                    $next = $current.next();
                    if (!$next) {
                        $next = $(".js-suggestions li:first-child");
                    }
    
                    $next.addClass("is-selected");
                    $current.removeClass("is-selected");
                } else {
                    $(".js-suggestions li:first-child").addClass("is-selected");
                }
                selectedURL = $(".js-suggestions .is-selected a").attr("href");
                $input.val($(".js-suggestions .is-selected a").text());
            }
        }
    
        //up arrow
        if (code == '38') {
            e.preventDefault();
            if ($(".js-suggestions li").length) {
                if ($(".js-suggestions .is-selected").length) {
                    $current = $(".js-suggestions .is-selected");
                    $next = $current.prev();
                    if (!$next) {
                        $next = $(".js-suggestions li:last-child");
                    }
    
                    $next.addClass("is-selected");
                    $current.removeClass("is-selected");
                } else {
                    $(".js-suggestions li:last-child").addClass("is-selected");
                }
                selectedURL = $(".js-suggestions .is-selected a").attr("href");
                $input.val($(".js-suggestions .is-selected a").text());
            }
        }
    
        // if esc key
        if (code == '27') {
            e.preventDefault();
            $input.val("").trigger("input");
            return false;
        }
    });
    
    //when input changes, load keyword suggestions
    var articleCache = {};
    $input.on("input", function(e) {
        var query = $(this).val();
        var length = query.length;
    
        if (length > 0) {
            $(".js-suggestions__hide-when-present").hide();
    
            //ajax call to get similar keywords
            $.getJSON("https://uits.iu.edu/keywordsJSONP.php?callback=?", function(data) {
                var keyword = "";
                var suggest = "";
                var first = false;
                var markup = "<ul class='js-suggestions'>";
                var numOfResults = 0;
    
                if (query == $input.val()) {
                    $(".js-suggestions").remove();
                    first = true;
                    for (var i = 0; i < data.length; i++) {
                        keyword = data[i].keyword.toLowerCase();
    
                        if (keyword.substring(0, length) == query.toLowerCase() && numOfResults < 5) {
                            numOfResults++;
                            if (first) {
                                suggest = keyword;
                                first = false;
                            }
    
                            markup += "<li class=''><a href='https://uits.iu.edu/search/?q=" + keyword + "'>" + keyword + "</a></li>";
                        }
                    }
                    markup += "</ul>";
    
                    if (numOfResults >= 1) {
                        $(".js-suggestions__target").html(markup);
                    } else {
                        $(".js-suggestions__target").html("<span class='js-suggestions'>Press enter to search</span>");
                    }
                }
            }).fail(function(){
                console.log("Fail: https://uits.iu.edu/keywordsJSONP.php")
            });
            
            // Search News Articles
            var renderArticleHtml = function(articles){
                if(!articles.length){ return ""; }
                var $newsResults = $("<div><h3>News</h3></div>");
                for(var k in articles){
                    var article = articles[k];
                    $newsResults.append("<a href='" + article.url + "'> <small>" + article.human_date + "</small> <br /> " + article.title + "</a>");
                }
                return $newsResults;
            }
            var displayArticles = function(articles){
                return $(".js-news-results__target").html(renderArticleHtml(articleCache[query]));
            }
            // check if cached
            if(articleCache[query]){
                displayArticles(articleCache[query]);
            } else {
                // get json
                $.getJSON("/data/articles?limit=10&q=" + query, function(articles){
                    articleCache[query] = articles;
                    displayArticles(articleCache[query]);
                }).fail(function(){
                    console.log("Fail: /data/articles?limit=10&q=" + query);
                });
            }
            
        } else {
            $(".js-news-results__target").html("");
            $(".js-suggestions").remove();
            $(".js-suggestions__hide-when-present").show();
        }
    });
    
    $search_form.on("submit", function(e) {
        var $searchInput = $('.search__input', this);
        var q = $searchInput.val();
        if (q == "") {
            $search_container.addClass("NO");
            $searchInput.focus();
            $searchInput.attr("placeholder", "Type here to search");
            setTimeout(function() {
                $search_container.removeClass("NO");
            }, 500)
            e.preventDefault();
        }
    });
    
});

$(document).ready(function(e) {

    /********************
     * UITS nav dropdowns
     *********************/
    var $uitsnavs = $(".uits-nav").each(function() {
        var $nav = $(this);
        $('.js-dropdown__trigger', $nav).each(function(k) {
            var $that = $(this);
            var $dropdown = $("." + $that.data('dropdown'), $nav);
            $that.click(function(e) {
                e.preventDefault();
                e.stopPropagation();
                var isOpen = $dropdown.is(":visible");
                closeDropdowns();
                if (!isOpen) {
                    $that.addClass('active');
                    $dropdown.show();
                }
            });
        });
    });

    var $uitsdropdowns = $(".uits-nav-dropdown").each(function() {
        $(".js-close-dropdown", this).click(closeDropdowns);
        $(this).click(function(e) {
            e.stopPropagation();
        });
    });

    function closeDropdowns() {
        $('.active', $uitsnavs).removeClass('active');
        $uitsdropdowns.hide();
    }

    $(window)
        .click(closeDropdowns)
        .resize($.throttle(250, function() {

        var subnavWidthResize = 50; // account for the column padding left and right
        var subnavContainerWidthResize = $('.subnav').width();
        $('.subnav ul li').each(function() {
            subnavWidthResize += $(this).width();
        });
        if (subnavContainerWidthResize != 1070 && (subnavWidthResize == 50 || subnavWidthResize > subnavContainerWidthResize)) {
            $('.subnav').addClass('nav-fix');
        } else {
            $('.subnav').removeClass('nav-fix');
        }


        if ($(window).width() < 642) {
            var height = $(window).height() - 48;
            $uitsdropdowns.css("height", height + "px");
        } else {
            $uitsdropdowns.css("height", "auto");
        }
    }));
    $(window).resize();
});

/********************
 * UITS nav Status.IU
 *********************/
$(document).ready(function(e) {
    var $ITNoticesDropDown = $('.uits-nav-dropdown--notices');
    var $ITNoticesList = $('.uits-nav-dropdown--notices .itnotices');
    var statusApiUrl = "https://uits.iu.edu/notices.json";
    var statusTypes = {
        "Information": 1,
        "Maintenance": 2,
        "Ongoing": 3,
        "Alert": 4
    };

    $.getJSON(statusApiUrl, function(results) {
        var $itnotices = $(".itnotices");
        if (!$itnotices.length) {
            $itnotices = $('<ul class="itnotices"> </ul>');
            $ITNoticesList.append($itnotices);
        }
        $itnotices.html("");
        var $count = $(".notices-link__count");
        var notices = filterNotices(results, statusTypes.Ongoing);
        var count = notices.length;
        var otherCount = results.length - count;
        for (var key in notices) {
            var notice = notices[key];
            $itnotices.append('<li class="type"><a href="https://status.uits.iu.edu/notice/' + notice.id + '" target="_blank"><i class="fa fa-' + notice.noticeType + ' ' + notice.noticeType + '"></i>' + notice.name + '</a></li>');
        }
        var highest = getHighestStatusLevel(notices);
        $count.addClass(highest).text(count);
    }).fail(function(){
        console.log("Failure: " + statusApiUrl)
    });

    function filterNotices(notices, minLevel) {
        var filtered = [];
        for (var k in notices) {
            if (statusTypes[notices[k].noticeType] >= minLevel) {
                filtered.push(notices[k]);
            }
        }
        return filtered;
    }

    function getHighestStatusLevel(notices) {
        var highestStatusLevel = '';
        for (var key in notices) {
            var notice = notices[key];
            var noticeType = notice.noticeType;
            if ((statusTypes[noticeType] || 0) > (statusTypes[highestStatusLevel] || 0)) {
                highestStatusLevel = noticeType
            }
        }
        return highestStatusLevel;
    }
});

/*
 * toggler
 */
$(document).ready(function() {
    $(".js-toggle").click(function(e) {
        e.stopPropagation();
        e.preventDefault();
        $target = $($(this).data("target"));
        if ($target.is(":visible")) {
            $target.hide().removeClass('show');
        } else {
            $target.show().addClass('show')
        }
    });
});