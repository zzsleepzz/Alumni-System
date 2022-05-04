package com.yuqi.alumnisystem.config;

import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperConfig {

//    private Converter<Date, String> dateToStringConverter = new AbstractConverter<Date, String>() {
//        @Override
//        protected String convert(Date date) {
//            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//            return date == null ? null : simpleDateFormat.format(date);
//        }
//    };
//
//    /**
//     * 将ModelMapper注册到Spring中
//     * 可以添加一些定制化的配置，官方文档：http://modelmapper.org/user-manual/property-mapping/
//     *
//     * @return org.modelmapper.ModelMapper
//     */
//    @Bean
//    public ModelMapper modelMapper() {
//        ModelMapper modelMapper = new ModelMapper();
//        // 完全匹配
//        modelMapper.getConfiguration().setFullTypeMatchingRequired(true);
//        // 匹配策略使用严格模式
//        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
//        modelMapper.addConverter(dateToStringConverter);
//        configureUser(modelMapper);
//        return modelMapper;
//    }
//
//    private void configureUser(ModelMapper modelMapper) {
////        modelMapper.typeMap(UserModel.class, User.class)
////                .addMappings(mapper -> mapper.skip(User::setPassword))
////                .addMappings(mapper -> mapper.skip(User::setCreateTime))
////                .addMappings(mapper -> mapper.skip(User::setUpdateTime))
////                .addMappings(mapper -> mapper.map(UserModel::getName, User::setRealName));
////
////        modelMapper.typeMap(User.class, UserModel.class)
////                .addMappings(mapper -> mapper.skip(UserModel::setPassword))
////                .addMappings(mapper -> mapper.map(User::getRealName, UserModel::setName));
////                .addMappings(mapper -> mapper.using(dateToStringConverter).map(User::getCreateTime, UserModel::setCreateTime))
////                .addMappings(mapper -> mapper.using(dateToStringConverter).map(User::getUpdateTime, UserModel::setUpdateTime));
//    }

}
