package br.com.silas.votenolivro.usertype;

import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SessionImplementor;
import org.hibernate.usertype.UserType;

import br.com.silas.votenolivro.enums.GeneroEnum;

public class GeneroUserType implements UserType {

	@Override
	public int[] sqlTypes() {
		return new int[] { Types.INTEGER };
	}
	
	@Override
	@SuppressWarnings("rawtypes")
	public Class returnedClass() {
		return GeneroEnum.class;
	}
	
	@Override
	public boolean equals(Object a, Object b) throws HibernateException {
		return (a == b) || ((a != null) && (b != null) && (a.equals(b)));
	}
	
	@Override
	public int hashCode(Object obj) throws HibernateException {
		return obj.hashCode();
	}
	
	@Override
	public Object assemble(Serializable cached, Object owner) throws HibernateException {
		return cached;
	}
	
	@Override
	public Object replace(Object original, Object target, Object owner) throws HibernateException {
		return original;
	}

	@Override
	public Object deepCopy(Object obj) throws HibernateException {
		return obj;
	}

	@Override
	public Serializable disassemble(Object value) throws HibernateException {
		return (Serializable) value;
	}

	@Override
	public boolean isMutable() {
		return false;
	}

	@Override
	public Object nullSafeGet(ResultSet rs, String[] names, SessionImplementor si, Object owner) throws HibernateException, SQLException {
		int id = rs.getInt(names[0]);
		if (rs.wasNull()) {
            return null;
        }
		for (GeneroEnum genero : GeneroEnum.values()) {
			if (genero.getCodigo().equals(id)) {
				return genero;
			}
		}
		return null;
	}

	@Override
	public void nullSafeSet(PreparedStatement st, Object value, int index, SessionImplementor si) throws HibernateException, SQLException {
		if (value == null) {
            st.setNull(index, Types.INTEGER);
        } else {
        	st.setInt(index, ((GeneroEnum) value).getCodigo());
        }
	}
}