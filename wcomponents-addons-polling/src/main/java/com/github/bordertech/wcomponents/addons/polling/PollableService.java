package com.github.bordertech.wcomponents.addons.polling;

import com.github.bordertech.taskmaster.service.ResultHolder;
import com.github.bordertech.taskmaster.service.ServiceAction;
import com.github.bordertech.wcomponents.addons.common.WDiv;
import java.io.Serializable;

/**
 * Polling component that creates a new thread to call a service and polls for the result.
 *
 * @author Jonathan Austin
 * @param <S> the criteria type
 * @param <T> the result type
 * @since 1.0.0
 */
public interface PollableService<S extends Serializable, T extends Serializable> extends Pollable {

	/**
	 * @return the container holding the result components
	 */
	WDiv getContentResultHolder();

	/**
	 * Manually set the criteria and the result.
	 *
	 * @param criteria the criteria
	 * @param result the result
	 */
	void doManuallyLoadResult(final S criteria, final T result);

	/**
	 * @return the service action to use for polling
	 */
	ServiceAction<S, T> getServiceAction();

	/**
	 * @param serviceAction the service action to use for polling
	 */
	void setServiceAction(final ServiceAction<S, T> serviceAction);

	/**
	 * @return the service criteria to use in the service call
	 */
	S getServiceCriteria();

	/**
	 * @param criteria the service criteria to use in the service call
	 */
	void setServiceCriteria(final S criteria);

	/**
	 * @return the service cache key
	 */
	String getServiceCacheKey();

	/**
	 * @param serviceCacheKey the service cache key
	 */
	void setServiceCacheKey(final String serviceCacheKey);

	/**
	 * @return the service thread pool, or null for default
	 */
	String getServiceThreadPool();

	/**
	 * @param serviceThreadPool the service thread pool or null for default
	 */
	void setServiceThreadPool(final String serviceThreadPool);

	/**
	 * @return true if use the cache to hold the service result
	 */
	boolean isUseCachedResult();

	/**
	 * @param useCachedResult true if use the cache to hold the service result
	 */
	void setUseCachedResult(final boolean useCachedResult);

	/**
	 * @param serviceResult the service result
	 */
	void setServiceResult(final ResultHolder<S, T> serviceResult);

	/**
	 * @return the service result, or null if still processing.
	 */
	ResultHolder<S, T> getServiceResult();

}
