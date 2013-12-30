package org.mford.gae.testAppv6.gae;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Nullable;
import javax.inject.Named;

import org.mford.gae.testAppv6.dao.impl.AnemometerDaoImpl;
import org.mford.gae.testAppv6.entity.Anemometer;
import org.mford.gae.testAppv6.entity.AnemometerReading;
import org.mford.gae.testAppv6.entity.AnemometerSite;
import org.mford.gae.testAppv6.entity.AnemometerSiteResponse;
import org.mford.gae.testAppv6.entity.ErrorCode;
import org.mford.gae.testAppv6.entity.ResultStatus;
import org.mford.gae.testAppv6.entity.SitesResponse;
import org.mford.gae.testAppv6.processor.impl.AnemometerReaderImpl;

import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;

@Api(name="wsep",
		version="v1",
		description = "Weather service end point")
public class WeatherStationEndPoint {
		
	public WeatherStationEndPoint(){
	}
	
	@ApiMethod(name="wstation.report",
			httpMethod=ApiMethod.HttpMethod.GET
	)
	public AnemometerSiteResponse report(@Nullable @Named("site") AnemometerSite site) {	
		List<AnemometerReading> list=null;
		AnemometerDaoImpl daoV2 = new AnemometerDaoImpl();
		String url = String.format("http://www.weather-file.com/%s/data/",site.getCode());
		
		daoV2.setHostSite(url);
		daoV2.setProcessor(new AnemometerReaderImpl());
		try {
			list = daoV2.read(new Date());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new AnemometerSiteResponse(site, new ArrayList<AnemometerReading>(), 
					ResultStatus.Error(ErrorCode.FAILED_TO_ACCESS_SITE,e.toString()));
		}

		return new AnemometerSiteResponse(site, list, ResultStatus.Success());
	}

	
	@ApiMethod(name="wstation.sites",
			httpMethod=ApiMethod.HttpMethod.GET
	)
	public SitesResponse sites() {	
		List<Anemometer> retVal = new ArrayList<Anemometer>();
		int i=0;
		for (AnemometerSite val : AnemometerSite.values())
			retVal.add(new Anemometer(i++, val, val.getCode(), val.getLat(), val.getLng()));
		return new SitesResponse(ResultStatus.Success(),retVal);
	}

}
