################################################################################
# Automatically-generated file. Do not edit!
################################################################################

# Add inputs and outputs from these tool invocations to the build variables 
C_SRCS += \
../src/Bsys_C.c 

OBJS += \
./src/Bsys_C.o 

C_DEPS += \
./src/Bsys_C.d 


# Each subdirectory must supply rules for building sources it contributes
src/Bsys_C.o: ../src/Bsys_C.c
	@echo 'Building file: $<'
	@echo 'Invoking: GCC C Compiler'
	gcc -O0 -g3 -Wall -c -fmessage-length=0 -MMD -MP -MF"$(@:%.o=%.d)" -MT"src/Bsys_C.d" -o "$@" "$<"
	@echo 'Finished building: $<'
	@echo ' '


