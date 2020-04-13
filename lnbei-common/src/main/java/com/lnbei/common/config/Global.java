package com.lnbei.common.config;

import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.lnbei.common.utils.StringUtils;
import com.lnbei.common.utils.YamlUtil;

/**
 * 全局配置类
 * 
 * @author lnbei
 */
public class Global {
	private static final Logger log = LoggerFactory.getLogger(Global.class);

	private static String NAME = "application.yml";

	/**
	 * 当前对象实例
	 */
	private static Global global = null;

	/**
	 * 保存全局属性值
	 */
	private static Map<String, String> map = new HashMap<String, String>();

	private Global() {
	}

	/**
	 * 静态工厂方法 获取当前对象实例 多线程安全单例模式(使用双重同步锁)
	 */

	public static synchronized Global getInstance() {
		if (global == null) {
			synchronized (Global.class) {
				if (global == null)
					global = new Global();
			}
		}
		return global;
	}

	/**
	 * 获取配置
	 */
	public static String getConfig(String key) {
		String value = map.get(key);
		if (value == null) {
			Map<?, ?> yamlMap = null;
			try {
				yamlMap = YamlUtil.loadYaml(NAME);
				value = String.valueOf(YamlUtil.getProperty(yamlMap, key));
				map.put(key, value != null ? value : StringUtils.EMPTY);
			} catch (FileNotFoundException e) {
				log.error("获取全局配置异常 {}", key);
			}
		}
		return value;
	}

	/**
	 * 获取项目名称
	 */
	public static String getName() {
		return StringUtils.nvl(getConfig("lnbei.name"), "RuoYi");
	}

	/**
	 * 获取项目版本
	 */
	public static String getVersion() {
		return StringUtils.nvl(getConfig("lnbei.version"), "3.2.0");
	}

	/**
	 * 获取版权年份
	 */
	public static String getCopyrightYear() {
		return StringUtils.nvl(getConfig("lnbei.copyrightYear"), "2018");
	}

	/**
	 * 获取ip地址开关
	 */
	public static Boolean isAddressEnabled() {
		return Boolean.valueOf(getConfig("lnbei.addressEnabled"));
	}

	/**
	 * 获取文件上传路径
	 */
	public static String getProfile() {
		return getConfig("lnbei.profile");
	}

	/**
	 * 获取头像上传路径
	 */
	public static String getAvatarPath() {
		return getConfig("lnbei.profile") + "avatar/";
	}

	/**
	 * 获取下载路径
	 */
	public static String getDownloadPath() {
		return getConfig("lnbei.profile") + "download/";
	}

	/**
	 * 获取上传路径
	 */
	public static String getUploadPath() {

		return getConfig("lnbei.profile") + "upload/";
	}

	public static String getUploadPathFloder() {
		String profile = getConfig("lnbei.profile");
		String [] pStrings = profile.split(":");
		return  pStrings[pStrings.length-1] + "upload/";
	}
}
