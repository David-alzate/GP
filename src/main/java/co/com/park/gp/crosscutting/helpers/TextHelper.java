package co.com.park.gp.crosscutting.helpers;

import java.util.regex.Pattern;

public class TextHelper {

	public static final String EMPTY = "";
	public static final String UNDERLINE = "_";
	
	private static final Pattern EMAIL_PATTERN = Pattern.compile("^[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,}$");

	private TextHelper() {
		super();
	}

	public static final boolean isNull(final String string) {
		return ObjectHelper.getObjectHelper().isNull(string);
	}

	public static final boolean isNullOrEmpty(final String string) {
		return isNull(string) || EMPTY.equals(applyTrim(string));
	}

	public static final String getDefaultValue(final String string, final String defaultValue) {
		return ObjectHelper.getObjectHelper().getDefaultValue(string, defaultValue);
	}

	public static final String getDefaultValue(final String string) {
		return getDefaultValue(string, EMPTY);
	}

	public static final String applyTrim(final String string) {
		return getDefaultValue(string).trim();
	}

	public static final String concatenate(final String... strings) {
		final var sb = new StringBuilder(EMPTY);

		if (!ObjectHelper.getObjectHelper().isNull(strings)) {
			for (final var string : strings) {
				sb.append(applyTrim(string));
			}
		}

		return sb.toString();
	}

	public static String reemplazarParametro(String mensaje, String... parametros) {
		String mensajeReemplazado = mensaje;
		for (int i = 0; i < parametros.length; i++) {
			String marcador = "${" + (i + 1) + "}";
			mensajeReemplazado = mensajeReemplazado.replace(marcador, parametros[i]);
		}
		return mensajeReemplazado;
	}
	
    public static final boolean isValidoEmail(final String email) {
        return !isNullOrEmpty(email) && EMAIL_PATTERN.matcher(email).matches();
    }
}