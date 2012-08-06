package org.fernandez.roberto.bdki.dao.core.impl;

import java.util.List;
import java.util.Map;

import org.fernandez.roberto.bdki.common.PropCriteriaAndValue;
import org.fernandez.roberto.bdki.common.QueryComparator;
import org.fernandez.roberto.bdki.common.SqlUtil;
import org.fernandez.roberto.bdki.common.exception.CorePersistenceException;
import org.fernandez.roberto.bdki.dao.core.CountLayerDAO;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;


/**
 * @author roberto
 * 
 */
public class CountLayerDAOImpl<T> extends CriteriaLayerDAOImpl<T> implements
		CountLayerDAO<T> {

	/**
	 * constructor.
	 * 
	 * @param clazz
	 *            The same class as the typed parameter used when defining
	 *            CoreDaoImpl<T> sadly we need it to be passed in the
	 *            constructor also to be able to access class methods
	 * @param sessionFactory
	 *            This is the sessionFactory to be injected upon construction of
	 *            the bean. Remember to annotate the constructor with @Autowired
	 *            annotation
	 */
	public CountLayerDAOImpl(Class<T> clazz, SessionFactory sessionFactory) {
		super(clazz, sessionFactory);
	}

	/**
	 * @author dbejar
	 * @return
	 * @see com.knowment.ncsisserver.persistence.core.dao.CountLayerDao#countAll()
	 */
	@Override
	public Integer countAll() {
		LOG.debug("count all " + clazz.getSimpleName() + " instances");
		StringBuilder sqlString = new StringBuilder(getSelectCountQuery());
		try {
			Query query = createQuery(sqlString);
			return Integer.valueOf(query.uniqueResult().toString());
		} catch (Exception re) {
			LOG.error("count all failed", re);
			throw new CorePersistenceException(I18N_FIND + I18N_FAILED, re);
		}
	}

	/**
	 * @author dbejar
	 * @param propertiesMap
	 * @return
	 * @see com.knowment.ncsisserver.persistence.core.dao.CountLayerDao#countByMapOfProperties(java.util.Map)
	 */
	@Override
	public Integer countByMapOfProperties(Map<String, ? extends Object> propertiesMap) {
		StringBuilder queryString = new StringBuilder(getSelectCountQuery()).append(WHERE);
		Query query = createQueryForMaps(queryString.toString(), QueryComparator.EQUALS,
				propertiesMap, null, null);
		return Integer.valueOf(query.uniqueResult().toString());
	}

	/**
	 * @author dbejar
	 * @param propertiesMap
	 * @return
	 * @see com.knowment.ncsisserver.persistence.core.dao.CountLayerDao#countLikeMapOfProperties(java.util.Map)
	 */
	@Override
	public Integer countLikeMapOfProperties(Map<String, ? extends Object> propertiesMap) {
		StringBuilder queryString = new StringBuilder(getSelectCountQuery()).append(WHERE);
		Query query = createQueryForMaps(queryString.toString(), QueryComparator.LIKE,
				propertiesMap, null, null);
		return Integer.valueOf(query.uniqueResult().toString());
	}

	/**
	 * @author dbejar
	 * @param propertyName
	 * @param value
	 * @return
	 * @see com.knowment.ncsisserver.persistence.core.dao.CountLayerDao#countLikeProperty(java.lang.String,
	 *      java.lang.Object)
	 */
	@Override
	public Integer countLikeProperty(String propertyName, Object value) {
		return countGenericUsingProperty(propertyName, QueryComparator.LIKE, value);
	}

	/**
	 * @author dbejar
	 * @param propertyName
	 * @param value
	 * @return
	 * @see com.knowment.ncsisserver.persistence.core.dao.CountLayerDao#countByProperty(java.lang.String,
	 *      java.lang.Object)
	 */
	@Override
	public Integer countByProperty(String propertyName, Object value) {
		return countGenericUsingProperty(propertyName, QueryComparator.EQUALS, value);
	}

	/**
	 * Performs the count HQL operation using the comparator (EQUALS, LIKE)
	 * 
	 * @author dbejar
	 * @param propertyName
	 * @param comparator
	 * @param value
	 * @return
	 */
	private Integer countGenericUsingProperty(String propertyName, QueryComparator comparator,
			Object value) {
		StringBuilder queryString = new StringBuilder(getSelectCountQuery()).append(WHERE);
		queryString.append(SqlUtil.createSingleWhereClause(propertyName, value, comparator));
		try {
			Query query = createQuery(queryString);
			setsParamToValueOrToLowercaseValue(query, propertyName, comparator, value, 0);
			return Integer.valueOf(query.uniqueResult().toString());
		} catch (Exception re) {
			LOG.error(I18N_COUNT + I18N_FAILED, re);
			throw new CorePersistenceException(I18N_FIND + I18N_FAILED, re);
		}
	}

	/**
	 * @author dbejar
	 * @param filter
	 * @return
	 * @see com.knowment.ncsisserver.persistence.core.dao.CountLayerDao#countUsingFilter(java.util.List)
	 */
	@Override
	public Integer countUsingFilter(List<PropCriteriaAndValue> filter) {
		Criteria criteria = createHibernateCriteriaObject(null, filter, null);
		criteria.setProjection(Projections.rowCount());
		return ((Integer) criteria.list().get(0)).intValue();
	}

}

