/**
 * Anibal Jose Rodriguez Orive
 * Ingenieria Ciencias y Sistemas
 * Universidad de San Carlos de Guatemala
 * Modulo Recursos Humanos
 */
package org.habitatguate.hgerp.seguridad.client.api;

import java.util.Date;
import java.util.List;

import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxBDPuesto;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxBDTest;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxEmpleado;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxSalario;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxTest;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxTestCompartidos;
import org.habitatguate.hgerp.seguridad.client.rrhh.valores_sesion;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

/**
 * The client-side stub for the RPC service.
 * 
 * @author arodriguez
 *
 */
@RemoteServiceRelativePath("login")
public interface RecursosHumanosService extends RemoteService {
	
	//metodos para insertar en la base de datos.................................................................................................................
	/**
	 * 
	 * @param user
	 * @param pass
	 * @param Nombre
	 * @param Apellido
	 * @param fecha_nacimiento
	 * @return
	 * @throws IllegalArgumentException
	 */
	String Registro(String user,String pass,String Nombre, String Apellido, 
			        Date fecha_nacimiento) throws IllegalArgumentException;
	/**
	 * 
	 * @param user
	 * @param password
	 * @return
	 * @throws IllegalArgumentException
	 */
	valores_sesion login_inicio(String user,String password) throws IllegalArgumentException;	
	/**
	 * 
	 * @param afiliacion_igss
	 * @param estado_civil
	 * @param sexo
	 * @param primer_apellido
	 * @param segundo_apellido
	 * @param apellido_casada
	 * @param primer_nombre
	 * @param segundo_nombre
	 * @param IVS
	 * @param pais
	 * @param nit
	 * @param No_Dependientes
	 * @param noCuenta
	 * @param tipoCuenta
	 * @param nombreBanco
	 * @param cui
	 * @param tipo_pasaporte
	 * @param no_pasaporte
	 * @param direccion_actual
	 * @param depto_municipio_residencia
	 * @param email
	 * @param telefono
	 * @param celular
	 * @param fecha_nacimiento
	 * @param tipo_licencia
	 * @param no_licencia
	 * @param centro_trabajo
	 * @param ocupacion
	 * @param fecha_ingreso
	 * @param codigo_ingreso
	 * @param profesion
	 * @param tipo_planilla
	 * @param salario_base
	 * @param total
	 * @param bonificacion
	 * @param URLFile
	 * @param KeyFile
	 * @param Estado
	 * @param pasaporte
	 * @param licencia
	 * @return
	 * @throws IllegalArgumentException
	 */
	Long Insertar_Emppleado(String afiliacion_igss,
            String estado_civil, String sexo, String primer_apellido,
            String segundo_apellido, String apellido_casada,
            String primer_nombre, String segundo_nombre, String IVS,
            String pais,String nit, String No_Dependientes, String noCuenta,
            String tipoCuenta, String nombreBanco,String cui, String tipo_pasaporte, 
            String no_pasaporte, String direccion_actual,
            String depto_municipio_residencia, String email, String telefono,
            String celular, Date fecha_nacimiento, String tipo_licencia,
            String no_licencia, String centro_trabajo, String ocupacion,
            Date fecha_ingreso, String codigo_ingreso, String profesion,
            String tipo_planilla, float salario_base, float total,
            float bonificacion,String  URLFile, String KeyFile,String Estado,
            String pasaporte, String licencia)  throws IllegalArgumentException;
	/**
	 * 
	 * @param id_empleado
	 * @param primer_nombre
	 * @param segundo_nombre
	 * @param primer_apellido
	 * @param segundo_apellido
	 * @param edad
	 * @param ocupacion
	 * @param parentesco
	 * @return
	 * @throws IllegalArgumentException
	 */
	Long Insertar_Familiar(Long id_empleado,String primer_nombre, String segundo_nombre,
			String primer_apellido, String segundo_apellido, int edad, String ocupacion,
			String parentesco)throws IllegalArgumentException;
	/**
	 * 
	 * @param id_empleado
	 * @param fecha1
	 * @param fecha2
	 * @param nivel_academico
	 * @param establecimiento
	 * @param titulo
	 * @param URLFile
	 * @param KeyFile
	 * @return
	 * @throws IllegalArgumentException
	 */
	Long Insertar_Academico(Long id_empleado, Date fecha1, Date fecha2,
			String nivel_academico, String establecimiento, String titulo
			,String  URLFile, String KeyFile)throws IllegalArgumentException;
	/**
	 * 
	 * @param id_empleado
	 * @param nombre_referencia
	 * @param telefono
	 * @param puesto_candidato
	 * @param empresa_referencia
	 * @param fecha1
	 * @param fecha2
	 * @param motivo_retiro
	 * @param salario_final
	 * @param actitudes_cualidades
	 * @param recomiendo
	 * @return
	 * @throws IllegalArgumentException
	 */
	Long Insertar_Referencia_Laboral(Long id_empleado,String nombre_referencia, String telefono, 
			String puesto_candidato,String empresa_referencia, Date fecha1, 
			Date fecha2,String motivo_retiro, float salario_final, String actitudes_cualidades,
			String recomiendo)throws IllegalArgumentException;
	/**
	 * 
	 * @param id_empleado
	 * @param nombre_referencia
	 * @param telefono
	 * @param puesto_candidato
	 * @param relacion
	 * @param actitudes_cualidades
	 * @return
	 * @throws IllegalArgumentException
	 */
	Long Insertar_Referencia_Personal(Long id_empleado,String nombre_referencia, String telefono, 
			String puesto_candidato, String relacion, String actitudes_cualidades)throws IllegalArgumentException;
	/**
	 * 
	 * @param id_empleado
	 * @param nivel
	 * @param idioma
	 * @param URLFile
	 * @param KeyFile
	 * @return
	 * @throws IllegalArgumentException
	 */
	Long Insertar_Idioma(Long id_empleado, String nivel, String idioma
			,String  URLFile, String KeyFile)throws IllegalArgumentException;
	/**
	 * 
	 * @param id_empleado
	 * @param pregunta1
	 * @param pregunt2
	 * @param pregunta3
	 * @param pregunta4
	 * @param pregunta5
	 * @param pregunta6
	 * @param pregunta7
	 * @param pregunta8
	 * @param pregunta9
	 * @param pregunta10
	 * @param fecha_test
	 * @param evaluador
	 * @param BDtest
	 * @param testBD
	 * @param tipo_test
	 * @return
	 * @throws IllegalArgumentException
	 */
	Long Insertar_Test(Long id_empleado,int pregunta1, int pregunt2, int pregunta3, int pregunta4,
			int pregunta5, int pregunta6, int pregunta7, int pregunta8,
			int pregunta9, int pregunta10, Date fecha_test, String evaluador,Long BDtest, boolean testBD,
			String tipo_test)throws IllegalArgumentException;
	/**
	 * 
	 * @param nombreTest
	 * @param pregunta1
	 * @param pregunt2
	 * @param pregunta3
	 * @param pregunta4
	 * @param pregunta5
	 * @param pregunta6
	 * @param pregunta7
	 * @param pregunta8
	 * @param pregunta9
	 * @param pregunta10
	 * @param fecha_test
	 * @param tipo_test
	 * @return
	 * @throws IllegalArgumentException
	 */
	Long Insertar_BDTest(String nombreTest,String pregunta1, String pregunt2, String pregunta3, String pregunta4,
			String pregunta5, String pregunta6, String pregunta7, String pregunta8,
			String pregunta9, String pregunta10, Date fecha_test,
			String tipo_test)throws IllegalArgumentException;
	/**
	 * 
	 * @param id_empleado
	 * @param fecha_puesto
	 * @param nombre_puesto
	 * @param funciones
	 * @param motivoPuesto
	 * @param activo
	 * @param jornada
	 * @param horasTrabajo
	 * @return
	 * @throws IllegalArgumentException
	 */
	Long Insertar_Puesto(Long id_empleado,Date fecha_puesto, String nombre_puesto, String funciones,
			String motivoPuesto, boolean activo, String jornada, String horasTrabajo)throws IllegalArgumentException;
	/**
	 * 
	 * @param fecha_puesto
	 * @param nombre_puesto
	 * @param funciones
	 * @return
	 * @throws IllegalArgumentException
	 */
	Long Insertar_BDPuesto(Date fecha_puesto, String nombre_puesto, String funciones) throws IllegalArgumentException;
	/**
	 * 
	 * @param id_empleado
	 * @param fecha_entrevista
	 * @param que_conoces
	 * @param por_que_trabajas_aqui
	 * @param como_se_describe
	 * @param trabajar_por_presion
	 * @param metas
	 * @param disponibilidad_inmediata
	 * @param disposicion_a_viajar
	 * @param flexibilidad_horario
	 * @param pretencion_salarial_minimo
	 * @param antecedentes_penales
	 * @param antecedentes_policiacos
	 * @param carta_recomendacion_laboral
	 * @param carta_recomendacion_personal
	 * @param vive_con_familia
	 * @param casa_propia
	 * @param entrevisto
	 * @param enfermedades
	 * @param aporte_casa
	 * @param tiene_deudas
	 * @param no_dependientes
	 * @param empresa_credito
	 * @param alquila
	 * @param pago_alquiler
	 * @param Otros_Ingresos
	 * @param amortizacion
	 * @return
	 * @throws IllegalArgumentException
	 */
	Long Insertar_Entrevista(Long id_empleado,Date fecha_entrevista, String que_conoces,
			String por_que_trabajas_aqui, String como_se_describe,
			String trabajar_por_presion, String metas,
			boolean disponibilidad_inmediata, boolean disposicion_a_viajar,
			boolean flexibilidad_horario, float pretencion_salarial_minimo,
			boolean antecedentes_penales, boolean antecedentes_policiacos,
			boolean carta_recomendacion_laboral,
			boolean carta_recomendacion_personal, boolean vive_con_familia,
			boolean casa_propia, String entrevisto, String enfermedades,
			float aporte_casa, boolean tiene_deudas, int no_dependientes,
			String empresa_credito, boolean alquila,float pago_alquiler,String Otros_Ingresos,
			float amortizacion)throws IllegalArgumentException;
	/**
	 * 
	 * @param id_empleado
	 * @param fecha
	 * @param descripcion
	 * @param tipo_historial
	 * @return
	 * @throws IllegalArgumentException
	 */
	Long Insertar_Historial(Long id_empleado,Date fecha, String descripcion, 
			String tipo_historial)throws IllegalArgumentException;
	/**
	 * 
	 * @param id_empleado
	 * @param fecha1
	 * @param fecha2
	 * @param descripcionl
	 * @return
	 * @throws IllegalArgumentException
	 */
	Long  Insertar_Vacaciones(Long id_empleado,Date fecha1, Date fecha2, 
			String descripcionl)throws IllegalArgumentException;
	/**
	 * 
	 * @param id_empleado
	 * @param Fecha
	 * @param salario
	 * @param tipoSalario
	 * @return
	 * @throws IllegalArgumentException
	 */
	Long Insertar_Salario(Long id_empleado,Date Fecha, float salario,
			String tipoSalario) throws IllegalArgumentException;
	/**
	 * 
	 * @param idEmpleado
	 * @param idTest
	 * @param idEmpleadoCompartido
	 * @return
	 * @throws IllegalArgumentException
	 */
	String InsertarCompartido(String idEmpleado, Long idTest, 
			Long idEmpleadoCompartido)throws IllegalArgumentException;

	//metodos para Actualizar en la base de datos.................................................................................................................
	/**
	 * 
	 * @param id
	 * @param Stringafiliacion_igss
	 * @param estado_civil
	 * @param sexo
	 * @param primer_apellido
	 * @param segundo_apellido
	 * @param apellido_casada
	 * @param primer_nombre
	 * @param segundo_nombre
	 * @param IVS
	 * @param pais
	 * @param nit
	 * @param No_Dependientes
	 * @param noCuenta
	 * @param tipoCuenta
	 * @param nombreBanco
	 * @param cui
	 * @param tipo_pasaporte
	 * @param no_pasaporte
	 * @param direccion_actual
	 * @param depto_municipio_residencia
	 * @param email
	 * @param telefono
	 * @param celular
	 * @param fecha_nacimiento
	 * @param tipo_licencia
	 * @param no_licencia
	 * @param centro_trabajo
	 * @param ocupacion
	 * @param fecha_ingreso
	 * @param codigo_ingreso
	 * @param profesion
	 * @param tipo_planilla
	 * @param salario_base
	 * @param total
	 * @param bonificacion
	 * @param URLFile
	 * @param KeyFile
	 * @param Estado
	 * @param pasaporte
	 * @param licencia
	 * @return
	 * @throws IllegalArgumentException
	 */
	Long Actualizar_Emppleado(Long id, String Stringafiliacion_igss,
            String estado_civil, String sexo, String primer_apellido,
            String segundo_apellido, String apellido_casada,
            String primer_nombre, String segundo_nombre, String IVS,
            String pais,String nit, String No_Dependientes,String noCuenta, String 
            tipoCuenta, String nombreBanco, String cui,
            String tipo_pasaporte, String no_pasaporte, String direccion_actual,
            String depto_municipio_residencia, String email, String telefono,
            String celular, Date fecha_nacimiento, String tipo_licencia,
            String no_licencia, String centro_trabajo, String ocupacion,
            Date fecha_ingreso, String codigo_ingreso, String profesion,
            String tipo_planilla, float salario_base, float total,
            float bonificacion,String  URLFile, String KeyFile,String Estado,
            String pasaporte, String licencia)  throws IllegalArgumentException;
	/**
	 * 
	 * @param id_empleado
	 * @param id
	 * @param primer_nombre
	 * @param segundo_nombre
	 * @param primer_apellido
	 * @param segundo_apellido
	 * @param edad
	 * @param ocupacion
	 * @param parentesco
	 * @return
	 * @throws IllegalArgumentException
	 */
	Long Actualizar_Familiar(Long id_empleado,Long id,String primer_nombre, String segundo_nombre,
			String primer_apellido, String segundo_apellido, int edad, String ocupacion,
			String parentesco)throws IllegalArgumentException;
	/**
	 * 
	 * @param id_empleado
	 * @param id
	 * @param fecha1
	 * @param fecha2
	 * @param nivel_academico
	 * @param establecimiento
	 * @param titulo
	 * @param URLFile
	 * @param KeyFile
	 * @return
	 * @throws IllegalArgumentException
	 */
	Long Actualizar_Academico(Long id_empleado,Long id, Date fecha1, Date fecha2,
			String nivel_academico, String establecimiento, String titulo
			,String  URLFile, String KeyFile)throws IllegalArgumentException;
	/**
	 * 
	 * @param id_empleado
	 * @param id
	 * @param nombre_referencia
	 * @param telefono
	 * @param puesto_candidato
	 * @param empresa_referencia
	 * @param fecha1
	 * @param fecha2
	 * @param motivo_retiro
	 * @param salario_final
	 * @param actitudes_cualidades
	 * @param recomiendo
	 * @return
	 * @throws IllegalArgumentException
	 */
	Long Actualizar_Referencia_Laboral(Long id_empleado,Long id,String nombre_referencia, String telefono, 
			String puesto_candidato,String empresa_referencia, Date fecha1, 
			Date fecha2,String motivo_retiro, float salario_final, String actitudes_cualidades,
			String recomiendo)throws IllegalArgumentException;
	/**
	 * 
	 * @param id_empleado
	 * @param id
	 * @param nombre_referencia
	 * @param telefono
	 * @param puesto_candidato
	 * @param relacion
	 * @param actitudes_cualidades
	 * @return
	 * @throws IllegalArgumentException
	 */
	Long Actualizar_Referencia_Personal(Long id_empleado,Long id,String nombre_referencia, String telefono, 
			String puesto_candidato, String relacion, String actitudes_cualidades)throws IllegalArgumentException;
	/**
	 * 
	 * @param id_empleado
	 * @param id
	 * @param nivel
	 * @param idioma
	 * @param URLFile
	 * @param KeyFile
	 * @return
	 * @throws IllegalArgumentException
	 */
	Long Actualizar_Idioma(Long id_empleado,Long id, String nivel, String idioma
			,String  URLFile, String KeyFile)throws IllegalArgumentException;
	/**
	 * 
	 * @param id_empleado
	 * @param id
	 * @param pregunta1
	 * @param pregunt2
	 * @param pregunta3
	 * @param pregunta4
	 * @param pregunta5
	 * @param pregunta6
	 * @param pregunta7
	 * @param pregunta8
	 * @param pregunta9
	 * @param pregunta10
	 * @param fecha_test
	 * @param evaluador
	 * @param BDtest
	 * @param testBD
	 * @param tipo_test
	 * @return
	 * @throws IllegalArgumentException
	 */
	Long Actualizar_Test(Long id_empleado,Long id,int pregunta1, int pregunt2, int pregunta3, int pregunta4,
			int pregunta5, int pregunta6, int pregunta7, int pregunta8,
			int pregunta9, int pregunta10, Date fecha_test, String evaluador,Long BDtest, boolean testBD,
			String tipo_test)throws IllegalArgumentException;
	/**
	 * 
	 * @param id
	 * @param nombreTest
	 * @param pregunta1
	 * @param pregunt2
	 * @param pregunta3
	 * @param pregunta4
	 * @param pregunta5
	 * @param pregunta6
	 * @param pregunta7
	 * @param pregunta8
	 * @param pregunta9
	 * @param pregunta10
	 * @param fecha_test
	 * @param tipo_test
	 * @return
	 * @throws IllegalArgumentException
	 */
	Long Actualizar_BDTest(Long id,String nombreTest,String pregunta1, String pregunt2, String pregunta3, String pregunta4,
			String pregunta5, String pregunta6, String pregunta7, String pregunta8,
			String pregunta9, String pregunta10, Date fecha_test,
			String tipo_test)throws IllegalArgumentException;
	/**
	 * 
	 * @param id_empleado
	 * @param id
	 * @param fecha_puesto
	 * @param nombre_puesto
	 * @param funciones
	 * @param motivoPuesto
	 * @param activo
	 * @param jornada
	 * @param horasTrabajo
	 * @return
	 * @throws IllegalArgumentException
	 */
	Long Actualizar_Puesto(Long id_empleado,Long id,Date fecha_puesto, String nombre_puesto, String funciones,
			String motivoPuesto, boolean activo, String jornada, String horasTrabajo)throws IllegalArgumentException;
	/**
	 * 
	 * @param id
	 * @param fecha_puesto
	 * @param nombre_puesto
	 * @param funciones
	 * @return
	 * @throws IllegalArgumentException
	 */
	Long Actualizar_BDPuesto(Long id,Date fecha_puesto, String nombre_puesto, String funciones)
			throws IllegalArgumentException;
	/**
	 * 
	 * @param id_empleado
	 * @param id
	 * @param fecha_entrevista
	 * @param que_conoces
	 * @param por_que_trabajas_aqui
	 * @param como_se_describe
	 * @param trabajar_por_presion
	 * @param metas
	 * @param disponibilidad_inmediata
	 * @param disposicion_a_viajar
	 * @param flexibilidad_horario
	 * @param pretencion_salarial_minimo
	 * @param antecedentes_penales
	 * @param antecedentes_policiacos
	 * @param carta_recomendacion_laboral
	 * @param carta_recomendacion_personal
	 * @param vive_con_familia
	 * @param casa_propia
	 * @param entrevisto
	 * @param enfermedades
	 * @param aporte_casa
	 * @param tiene_deudas
	 * @param no_dependientes
	 * @param empresa_credito
	 * @param alquila
	 * @param pago_alquiler
	 * @param Otros_Ingresos
	 * @param amortizacion
	 * @return
	 * @throws IllegalArgumentException
	 */
	Long Actualizar_Entrevista(Long id_empleado,Long id,Date fecha_entrevista, String que_conoces,
			String por_que_trabajas_aqui, String como_se_describe,
			String trabajar_por_presion, String metas,
			boolean disponibilidad_inmediata, boolean disposicion_a_viajar,
			boolean flexibilidad_horario, float pretencion_salarial_minimo,
			boolean antecedentes_penales, boolean antecedentes_policiacos,
			boolean carta_recomendacion_laboral,
			boolean carta_recomendacion_personal, boolean vive_con_familia,
			boolean casa_propia, String entrevisto, String enfermedades,
			float aporte_casa, boolean tiene_deudas, int no_dependientes,
			String empresa_credito, boolean alquila,float pago_alquiler,
			String Otros_Ingresos,float amortizacion)throws IllegalArgumentException;
	/**
	 * 
	 * @param id_empleado
	 * @param id
	 * @param fecha
	 * @param descripcion
	 * @param tipo_historial
	 * @return
	 * @throws IllegalArgumentException
	 */
	Long Actualizar_Historial(Long id_empleado,Long id,Date fecha, String descripcion, 
			String tipo_historial)throws IllegalArgumentException;
	/**
	 * 
	 * @param id_empleado
	 * @param id
	 * @param fecha1
	 * @param fecha2
	 * @param descripcionl
	 * @return
	 * @throws IllegalArgumentException
	 */
	Long  Actualizar_Vacaciones(Long id_empleado,Long id,Date fecha1, Date fecha2, 
			String descripcionl)throws IllegalArgumentException;
	/**
	 * 
	 * @param id_empleado
	 * @param id
	 * @param Fecha
	 * @param salario
	 * @param tipoSalario
	 * @return
	 * @throws IllegalArgumentException
	 */
	Long Actualizar_Salario(Long id_empleado,Long id,Date Fecha, 
			float salario,String tipoSalario) throws IllegalArgumentException;
	
	//metodos para Eliminar en la base de datos
    /**
     * 
     * @param id
     * @return
     * @throws IllegalArgumentException
     */
	Long Eliminar_Emppleado(Long id)  throws IllegalArgumentException;
    /**
     * 
     * @param id_empleado
     * @param id
     * @return
     * @throws IllegalArgumentException
     */
    Long Eliminar_Familiar(Long id_empleado,Long id)throws IllegalArgumentException;
    /**
     * 
     * @param id_empleado
     * @param id
     * @return
     * @throws IllegalArgumentException
     */
    Long Eliminar_Academico(Long id_empleado,Long id)throws IllegalArgumentException;
    /**
     * 
     * @param id_empleado
     * @param id
     * @return
     * @throws IllegalArgumentException
     */
    Long Eliminar_Referencia_Laboral(Long id_empleado,Long id)throws IllegalArgumentException;
    /**
     * 
     * @param id_empleado
     * @param id
     * @return
     * @throws IllegalArgumentException
     */
    Long Eliminar_Referencia_Personal(Long id_empleado,Long id)throws IllegalArgumentException;
    /**
     * 
     * @param id_empleado
     * @param id
     * @return
     * @throws IllegalArgumentException
     */
    Long Eliminar_Idioma(Long id_empleado,Long id)throws IllegalArgumentException;
    /**
     * 
     * @param id_empleado
     * @param id
     * @return
     * @throws IllegalArgumentException
     */
    Long Eliminar_Test(Long id_empleado,Long id)throws IllegalArgumentException;
    /**
     * 
     * @param id_empleado
     * @param id
     * @return
     * @throws IllegalArgumentException
     */
    Long Eliminar_Puesto(Long id_empleado,Long id)throws IllegalArgumentException;
    /**
     * 
     * @param id_empleado
     * @param id
     * @return
     * @throws IllegalArgumentException
     */
    Long Eliminar_Entrevista(Long id_empleado,Long id)throws IllegalArgumentException;
    /**
     * 
     * @param id_empleado
     * @param id
     * @return
     * @throws IllegalArgumentException
     */
    Long Eliminar_Historial(Long id_empleado,Long id)throws IllegalArgumentException;
    /**
     * 
     * @param id_empleado
     * @param id
     * @return
     * @throws IllegalArgumentException
     */
    Long Eliminar_Vacaciones(Long id_empleado,Long id)throws IllegalArgumentException;
    /**
     * 
     * @param id_empleado
     * @param id
     * @return
     * @throws IllegalArgumentException
     */
    Long Eliminar_Salario(Long id_empleado,Long id)throws IllegalArgumentException;
    /**
     * 
     * @param fileURL
     * @return
     * @throws IllegalArgumentException
     */
    String remove(String fileURL)throws IllegalArgumentException;
    /**
     * 
     * @param idEmpleado
     * @param idTest
     * @return
     * @throws IllegalArgumentException
     */
	String QuitarCompartido(Long idEmpleado, Long idTest)throws IllegalArgumentException;


    ///querys
	/**
	 * 
	 * @param tipo
	 * @param primer_nombre
	 * @param segundo_nombre
	 * @param primer_apellido
	 * @param segundo_apellido
	 * @param DPI
	 * @param Pasaporte
	 * @param Estado
	 * @return
	 * @throws IllegalArgumentException
	 */
    List<AuxEmpleado> Buscar_Empleado(char tipo, String primer_nombre, String segundo_nombre, 
			String primer_apellido, String segundo_apellido,String DPI, String Pasaporte,
			String Estado) throws IllegalArgumentException;    
    /**
     * 
     * @return
     * @throws IllegalArgumentException
     */
    List<AuxBDPuesto> BDPuesto()throws IllegalArgumentException;
    /**
     * 
     * @return
     * @throws IllegalArgumentException
     */
    List<AuxBDTest> BDTest()throws IllegalArgumentException;
    /**
     * 
     * @return
     * @throws IllegalArgumentException
     */
    List<String> getCorreos()throws IllegalArgumentException;
    /**
     * 
     * @return
     * @throws IllegalArgumentException
     */
    List<AuxSalario> getSalarios()throws IllegalArgumentException;
    /**
     * 
     * @param id
     * @return
     * @throws IllegalArgumentException
     */
    List<AuxTestCompartidos> getEvaluacionesCompartidas(Long id)throws IllegalArgumentException;
    /**
     * 
     * @param idTest
     * @param id
     * @return
     * @throws IllegalArgumentException
     */
    AuxTest getTest(Long idTest,Long id)throws IllegalArgumentException;    
    /**
     * 
     * @param id_empleado
     * @return
     * @throws IllegalArgumentException
     */
    AuxEmpleado Empleado_Registrado(Long id_empleado) throws IllegalArgumentException;
    
	
    

}
