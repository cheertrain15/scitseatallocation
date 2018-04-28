$(document).ready(function () {

    /*
     * article filter
     */
    var api_url = "https://itnews.iu.edu/data/article";
    var guid = $('#page_guid').val();
    var $stories = $(".stories");
    var $relatedLinks = $(".related-stories-latest");
    var loadingHtml = '<i class="fa fa-cog fa-spin fa-2x fa-fw"></i>';
    var labels = {
        "all-categories": "All categories",
        "news-and-events": "News &amp; Events",
        "discovery": "Discovery",
        "high-performance": "High performance",
        "services-and-support": "Services &amp; Support",
        "teaching-and-learning": "Teaching &amp; Learning",
        "external-only": "External only",
        "all-tags": "All tags",
        "discounts": "Discounts",
        "etexts": "eTexts",
        "events": "Events",
        "mobile": "Mobile",
        "networking": "Networking",
        "privacy": "Privacy",
        "pti": "PTI",
        "research": "Research",
        "research-technologies": "Research technologies",
        "security": "Security",
        "social-networking": "Social networking",
        "software": "Software",
        "STCs": "STCs",
        "students": "Students",
        "support": "Support",
        "sustainability": "Sustainability",
        "teaching-learning": "Teaching &amp; Learning",
        "training": "Training",
        "wireless": "Wireless",
        "uits": "UITS"
    };
    var months = ["January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"]

    // get related
    $.getJSON(api_url + '/' + guid + '/related?limit=5', function (data) {
        $linkList = $("<ul class='related-links clearfix'>");
        for (var k in data) {
            var link = data[k];
            $linkList.append("<li> <a href='" + link.url + "' target='_blank'>" + link.title + "</a></li>")
        }

        $relatedLinks.html("<h2>Related Articles</h2>");
        $relatedLinks.append($linkList);
    }).fail(function(){
       console.log("error loading " + api_url + '/' + guid + '/related?limit=5'); 
    });
    // get siblings
    $.getJSON(api_url + '/' + guid + '/siblings', function (data) {
        $stories.html('');
        if (data && data.previous) {
            $stories.append('<div class="stories-link stories-link--prev"> <a href="' + data.previous.url + '"><span>Previous article</span>' + data.previous.title + '</a> </div>');
        }
        if (data && data.next) {
            $stories.append('<div class="stories-link stories-link--next"> <a href="' + data.next.url + '"><span>Next article</span>' + data.next.title + '</a> </div>');
        }
    }).fail(function(){
       console.log("error loading " + api_url + '/' + guid + '/siblings?limit=5'); 
    });
});