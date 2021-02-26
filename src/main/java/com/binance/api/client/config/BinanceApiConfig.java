package com.binance.api.client.config;

import org.apache.commons.lang3.StringUtils;

import java.net.InetSocketAddress;
import java.net.Proxy;

/**
 * Configuration used for Binance operations.
 */
public class BinanceApiConfig {

	/**
	 * Base domain for URLs.
	 */
	private static String BASE_DOMAIN = "binance.com";
	private static String API_BASE_URL = null;
	private static String STREAM_API_BASEURL = null;
	private static String ASSET_INFO_API_BASEURL = null;
	private static Proxy PROXY = null;

	public static Proxy getProxy(){
		return PROXY;
	}
	public static void setProxy(String hostname, int port){
		 PROXY =new Proxy(Proxy.Type.HTTP,new InetSocketAddress(hostname, port));;
	}

	/**
	 * Set the URL base domain name (e.g., binance.com).
	 *
	 * @param baseDomain Base domain name
	 */
	public static void setBaseDomain(final String baseDomain) {
		BASE_DOMAIN = baseDomain;
	}

	/**
	 * Get the URL base domain name (e.g., binance.com).
	 *
	 * @return The base domain for URLs
	 */
	public static String getBaseDomain() {
		return BASE_DOMAIN;
	}

	/**
	 * REST API base URL.
	 */
	public static String getApiBaseUrl() {
		if (StringUtils.isBlank(API_BASE_URL)){
			return String.format("https://api.%s", getBaseDomain());
		}
		return API_BASE_URL;

	}

	/**
	 * REST API base URL.
	 */
	public static void setApiBaseUrl(String apiBaseUrl) {
		API_BASE_URL=apiBaseUrl;
	}

	/**
	 * Streaming API base URL.
	 */
	public static String getStreamApiBaseUrl() {
		if (StringUtils.isBlank(STREAM_API_BASEURL)){
			return String.format("wss://stream.%s:9443/ws", getBaseDomain());
		}
		return STREAM_API_BASEURL;

	}

	public static void setStreamApiBaseUrl(String streamApiBaseUrl) {
		STREAM_API_BASEURL=streamApiBaseUrl;
	}

	/**
	 * Asset info base URL.
	 */
	public static String getAssetInfoApiBaseUrl() {
		if (StringUtils.isBlank(ASSET_INFO_API_BASEURL)){
			return String.format("https://%s/", getBaseDomain());
		}
		return ASSET_INFO_API_BASEURL;

	}

	public static void setAssetInfoApiBaseUrl(String assetInfoApiBaseUrl) {
		ASSET_INFO_API_BASEURL=assetInfoApiBaseUrl;
	}

}
