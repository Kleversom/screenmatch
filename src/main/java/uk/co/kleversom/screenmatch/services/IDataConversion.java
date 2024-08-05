package uk.co.kleversom.screenmatch.services;

public interface IDataConversion {
    <T> T getData(String json, Class<T> classe);
}
