################################################################################
# Automatically-generated file. Do not edit!
################################################################################

# Add inputs and outputs from these tool invocations to the build variables 
CPP_SRCS += \
C:\Users\filip\Documents\Arduino\libraries\Adafruit_NeoPixel\Adafruit_NeoPixel.cpp 

C_SRCS += \
C:\Users\filip\Documents\Arduino\libraries\Adafruit_NeoPixel\esp8266.c 

C_DEPS += \
.\libraries\Adafruit_NeoPixel\esp8266.c.d 

LINK_OBJ += \
.\libraries\Adafruit_NeoPixel\Adafruit_NeoPixel.cpp.o \
.\libraries\Adafruit_NeoPixel\esp8266.c.o 

CPP_DEPS += \
.\libraries\Adafruit_NeoPixel\Adafruit_NeoPixel.cpp.d 


# Each subdirectory must supply rules for building sources it contributes
libraries\Adafruit_NeoPixel\Adafruit_NeoPixel.cpp.o: C:\Users\filip\Documents\Arduino\libraries\Adafruit_NeoPixel\Adafruit_NeoPixel.cpp
	@echo 'Building file: $<'
	@echo 'Starting C++ compile'
	"C:\Users\filip\eclipse\java-2018-12\eclipse\arduinoPlugin\packages\arduino\tools\avr-gcc\5.4.0-atmel3.6.1-arduino2/bin/avr-g++" -c -g -Os -Wall -Wextra -std=gnu++11 -fpermissive -fno-exceptions -ffunction-sections -fdata-sections -fno-threadsafe-statics -Wno-error=narrowing -MMD -flto -mmcu=atmega328p -DF_CPU=16000000L -DARDUINO=10802 -DARDUINO_AVR_UNO -DARDUINO_ARCH_AVR     -I"C:\Users\filip\eclipse\java-2018-12\eclipse\arduinoPlugin\packages\arduino\hardware\avr\1.6.23\cores\arduino" -I"C:\Users\filip\eclipse\java-2018-12\eclipse\arduinoPlugin\packages\arduino\hardware\avr\1.6.23\variants\standard" -I"C:\Users\filip\Documents\Arduino\libraries\Adafruit_NeoPixel" -I"C:\Users\filip\Documents\Arduino\libraries\ArduinoJson\src" -MMD -MP -MF"$(@:%.o=%.d)" -MT"$(@)" -D__IN_ECLIPSE__=1 -x c++ "$<"  -o  "$@"
	@echo 'Finished building: $<'
	@echo ' '

libraries\Adafruit_NeoPixel\esp8266.c.o: C:\Users\filip\Documents\Arduino\libraries\Adafruit_NeoPixel\esp8266.c
	@echo 'Building file: $<'
	@echo 'Starting C compile'
	"C:\Users\filip\eclipse\java-2018-12\eclipse\arduinoPlugin\packages\arduino\tools\avr-gcc\5.4.0-atmel3.6.1-arduino2/bin/avr-gcc" -c -g -Os -Wall -Wextra -std=gnu11 -ffunction-sections -fdata-sections -MMD -flto -fno-fat-lto-objects -mmcu=atmega328p -DF_CPU=16000000L -DARDUINO=10802 -DARDUINO_AVR_UNO -DARDUINO_ARCH_AVR     -I"C:\Users\filip\eclipse\java-2018-12\eclipse\arduinoPlugin\packages\arduino\hardware\avr\1.6.23\cores\arduino" -I"C:\Users\filip\eclipse\java-2018-12\eclipse\arduinoPlugin\packages\arduino\hardware\avr\1.6.23\variants\standard" -I"C:\Users\filip\Documents\Arduino\libraries\Adafruit_NeoPixel" -I"C:\Users\filip\Documents\Arduino\libraries\ArduinoJson\src" -MMD -MP -MF"$(@:%.o=%.d)" -MT"$(@)" -D__IN_ECLIPSE__=1 "$<"  -o  "$@"
	@echo 'Finished building: $<'
	@echo ' '


