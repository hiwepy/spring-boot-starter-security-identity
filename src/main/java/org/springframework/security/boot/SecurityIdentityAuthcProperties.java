/*
 * Copyright (c) 2018, vindell (https://github.com/vindell).
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package org.springframework.security.boot;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.NestedConfigurationProperty;
import org.springframework.security.boot.biz.property.SecurityAuthcProperties;
import org.springframework.security.boot.biz.property.SecurityHeaderCrosProperties;
import org.springframework.security.boot.biz.property.SecurityHeaderCsrfProperties;
import org.springframework.security.boot.biz.property.SecurityHeadersProperties;
import org.springframework.security.boot.biz.property.SecurityLogoutProperties;
import org.springframework.security.boot.biz.property.SecurityRedirectProperties;
import org.springframework.security.boot.identity.authentication.IdentityCodeAuthenticationProcessingFilter;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ConfigurationProperties(SecurityIdentityAuthcProperties.PREFIX)
@Getter
@Setter
@ToString
public class SecurityIdentityAuthcProperties extends SecurityAuthcProperties {

	public static final String PREFIX = "spring.security.identity.authc";
	
	/** the mobile parameter name. Defaults to "username". */
	private String mobileParameter = IdentityCodeAuthenticationProcessingFilter.SPRING_SECURITY_FORM_MOBILE_KEY;
	/** the code parameter name. Defaults to "password". */
    private String codeParameter = IdentityCodeAuthenticationProcessingFilter.SPRING_SECURITY_FORM_CODE_KEY;
	
    @NestedConfigurationProperty
	private SecurityHeaderCrosProperties cros = new SecurityHeaderCrosProperties();
	
	@NestedConfigurationProperty
	private SecurityHeaderCsrfProperties csrf = new SecurityHeaderCsrfProperties();
	
	@NestedConfigurationProperty
	private SecurityHeadersProperties headers = new SecurityHeadersProperties();
	
	@NestedConfigurationProperty
	private SecurityRedirectProperties redirect = new SecurityRedirectProperties();

	@NestedConfigurationProperty
	private SecurityLogoutProperties logout = new SecurityLogoutProperties();
	
	
}
