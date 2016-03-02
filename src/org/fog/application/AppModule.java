package org.fog.application;

import java.util.Map;

import org.apache.commons.math3.util.Pair;
import org.cloudbus.cloudsim.CloudletScheduler;
import org.cloudbus.cloudsim.Vm;
import org.fog.scheduler.TupleScheduler;
import org.fog.utils.FogUtils;
import org.fog.utils.GeoCoverage;

public class AppModule extends Vm{

	private String name;
	private GeoCoverage geoCoverage;
	private String appId;
	private Map<Pair<String, String>, Double> selectivityMap;
	
	public AppModule(
			int id,
			String name,
			GeoCoverage geoCoverage,
			String appId,
			int userId,
			double mips,
			int ram,
			long bw,
			long size,
			String vmm,
			CloudletScheduler cloudletScheduler) {
		super(id, userId, mips, 1, ram, bw, size, vmm, cloudletScheduler);
		setName(name);
		setId(id);
		setGeoCoverage(geoCoverage);
		setAppId(appId);
		setUserId(userId);
		setUid(getUid(userId, id));
		setMips(mips);
		setNumberOfPes(1);
		setRam(ram);
		setBw(bw);
		setSize(size);
		setVmm(vmm);
		setCloudletScheduler(cloudletScheduler);
		setInMigration(false);
		setBeingInstantiated(true);
		setCurrentAllocatedBw(0);
		setCurrentAllocatedMips(null);
		setCurrentAllocatedRam(0);
		setCurrentAllocatedSize(0);
	}
	public AppModule(AppModule operator) {
		super(FogUtils.generateEntityId(), operator.getUserId(), operator.getMips(), 1, operator.getRam(), operator.getBw(), operator.getSize(), operator.getVmm(), new TupleScheduler(operator.getMips(), 1));
		setName(operator.getName());
		setGeoCoverage(operator.getGeoCoverage());
		setAppId(operator.getAppId());
		setInMigration(false);
		setBeingInstantiated(true);
		setCurrentAllocatedBw(0);
		setCurrentAllocatedMips(null);
		setCurrentAllocatedRam(0);
		setCurrentAllocatedSize(0);
	}
	
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public GeoCoverage getGeoCoverage() {
		return geoCoverage;
	}
	public void setGeoCoverage(GeoCoverage geoCoverage) {
		this.geoCoverage = geoCoverage;
	}
	public Map<Pair<String, String>, Double> getSelectivityMap() {
		return selectivityMap;
	}
	public void setSelectivityMap(Map<Pair<String, String>, Double> selectivityMap) {
		this.selectivityMap = selectivityMap;
	}
	public String getAppId() {
		return appId;
	}
	public void setAppId(String appId) {
		this.appId = appId;
	}
}