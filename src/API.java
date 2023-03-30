public enum API {
    IMDB_TOP_MOVIES("https://raw.githubusercontent.com/lukadev08/lukadev08.github.io/main/apidata/imdbtop250moviesdata.json", new IMDBContentExtractor()),
    NASA("https://api.nasa.gov/planetary/apod?api_key=6QxCgNSDuBbgIhke6m3aymdgbSIRNYndw6p84EhJ&start_date=2023-03-27&end_date=2023-03-30", new NasaContentExtractor());

    private String url;
    private ContentExtractor extractor;

    API(String url, ContentExtractor extractor) {
        this.url = url;
        this.extractor = extractor;
    }

    public String getUrl() {
        return url;
    }

    public ContentExtractor getExtractor() {
        return extractor;
    }
}
