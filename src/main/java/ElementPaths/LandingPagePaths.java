package ElementPaths;

public interface LandingPagePaths {
    String searchBarInputField = "//input[@id='app-search']";    //css
    String searchResultList = "ul.searchSuggestionBoxChild>li";    //css
    String searchResultListSingle = "ul.searchSuggestionBoxChild>li:first-of-type";    //css
    String countryList = "li[class=\"flagBox\"]>div>a#dropdownMenuLink[role=\"button\"]";
    String countryListItems = "li[class=\"flagBox\"]>div>div>form>li>a";
}

