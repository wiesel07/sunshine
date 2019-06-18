package cn.sunshine.common.config;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.boot.jackson.JsonComponent;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/**
 * <p>
 * 全局日期格式化
 * </p>
 *
 * @author wuj
 * @since 2019年6月18日
 */
@JsonComponent
public class DateFormatConfig {
	private static SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
    
	/**
	 * 将Date日期格式化为日期字符串
	 */
	public static class DateJsonSerializer extends JsonSerializer<Date> {
		@Override
		public void serialize(Date date, JsonGenerator jsonGenerator, SerializerProvider serializerProvider)
				throws IOException {
			jsonGenerator.writeString(dateFormat.format(date));
		}
	}

	/**
	 * 将日期字符串解析为Date日期
	 */
	public static class DateJsonDeserializer extends JsonDeserializer<Date> {
		@Override
		public Date deserialize(JsonParser jsonParser, DeserializationContext deserializationContext)
				throws IOException, JsonProcessingException {
			try {
				return dateFormat.parse(jsonParser.getText());
			} catch (ParseException e) {
				throw new RuntimeException(e);
			}
		}
	}
}


