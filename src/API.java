public enum API {
    IMDB_TOP_MOVIES("https://raw.githubusercontent.com/lukadev08/lukadev08.github.io/main/apidata/imdbmostpopularmovies.json"),
    NASA("https://api.nasa.gov/planetary/apod?api_key=6QxCgNSDuBbgIhke6m3aymdgbSIRNYndw6p84EhJ&start_date=2023-03-27&end_date=2023-03-30");

    private String url;

    API(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }
}
