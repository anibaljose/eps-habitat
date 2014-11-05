package org.habitatguate.hgerp.seguridad.service;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ExportAs
 */
@WebServlet("/ExportBancos")
public class ExportBancos extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    public ExportBancos() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		InformBancosXml n = new InformBancosXml();
		response.setContentType("application/vnd.ms-excel");
		response.setHeader("Content-Disposition", "inline; Filename=document_name.xls");
		
		String tipo = request.getParameter("tipo");
		String primer_nombre = request.getParameter("primer_nombre");
		String segundo_nombre = request.getParameter("segundo_nombre");
		String primer_apellido = request.getParameter("primer_apellido");
		String segundo_apellido = request.getParameter("segundo_apellido");
		String DPI = request.getParameter("DPI");
		String Pasaporte = request.getParameter("Pasaporte");
		String listMes = request.getParameter("listMes");
		String estado = request.getParameter("estado");
		String listAnio = request.getParameter("annio");
		String  xmlFinal = "";
		String inicio= "<html xmlns:o='urn:schemas-microsoft-com:office:office' xmlns:x='urn:schemas-microsoft-com:office:excel' "
				+ "xmlns='http://www.w3.org/TR/REC-html40'><head><!--[if gte mso 9]><xml><x:ExcelWorkbook><x:ExcelWorksheets><x:ExcelWorksheet>"
				+ "<x:Name>name</x:Name><x:WorksheetOptions><x:DisplayGridlines/></x:WorksheetOptions></x:ExcelWorksheet></x:ExcelWorksheets>"
				+ "</x:ExcelWorkbook></xml><![endif]--></head><body>";
		try{
			xmlFinal = inicio + n.Bancos(tipo.charAt(0), primer_nombre, segundo_nombre, primer_apellido, segundo_apellido, DPI, Pasaporte, estado, listMes, listAnio);
		}catch(Exception e){
			xmlFinal = "";
		}
		PrintWriter out = response.getWriter();
		out.write(xmlFinal);
		
	}
	
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		response.setContentType("application/vnd.ms-excel");
//		response.setHeader("Content-Disposition", "inline; Filename=document_name.xls");
//		PrintWriter out = response.getWriter();
//		out.write("<html xmlns:o='urn:schemas-microsoft-com:office:office' xmlns:x='urn:schemas-microsoft-com:office:excel' xmlns='http://www.w3.org/TR/REC-html40'><head><!--[if gte mso 9]><xml><x:ExcelWorkbook><x:ExcelWorksheets><x:ExcelWorksheet><x:Name>name</x:Name><x:WorksheetOptions><x:DisplayGridlines/></x:WorksheetOptions></x:ExcelWorksheet></x:ExcelWorksheets></x:ExcelWorkbook></xml><![endif]--></head><body><table><tbody><tr><td>Aerolinea</td><td>Cod. Vuelo</td><td>Destino</td><td>Horario</td><td>Puerta</td><td>Estado</td></tr><tr><td>0</td><td>0</td><td>0</td><td>0</td><td>0</td><td><input type='checkbox' id='flight-status-0' value='1' onchange='saveFlightStatus(&quot;0&quot;)' '=''><label for='flight-status-0'>on</label></td></tr><tr><td>1</td><td>1</td><td>1</td><td>1</td><td>1</td><td><input type='checkbox' id='flight-status-1' value='1' onchange='saveFlightStatus(&quot;1&quot;)' '=''><label for='flight-status-1'>on</label></td></tr><tr><td>2</td><td>2</td><td>2</td><td>2</td><td>2</td><td><input type='checkbox' id='flight-status-2' value='1' onchange='saveFlightStatus(&quot;2&quot;)' '=''><label for='flight-status-2'>on</label></td></tr><tr><td>3</td><td>3</td><td>3</td><td>3</td><td>3</td><td><input type='checkbox' id='flight-status-3' value='1' onchange='saveFlightStatus(&quot;3&quot;)' '=''><label for='flight-status-3'>on</label></td></tr><tr style='display: none;'><td>4</td><td>4</td><td>4</td><td>4</td><td>4</td><td><input type='checkbox' id='flight-status-4' value='1' onchange='saveFlightStatus(&quot;4&quot;)' '=''><label for='flight-status-4'>on</label></td></tr><tr style='display: none;'><td>5</td><td>5</td><td>5</td><td>5</td><td>5</td><td><input type='checkbox' id='flight-status-5' value='1' onchange='saveFlightStatus(&quot;5&quot;)' '=''><label for='flight-status-5'>on</label></td></tr><tr style='display: none;'><td>6</td><td>6</td><td>6</td><td>6</td><td>6</td><td><input type='checkbox' id='flight-status-6' value='1' onchange='saveFlightStatus(&quot;6&quot;)' '=''><label for='flight-status-6'>on</label></td></tr><tr style='display: none;'><td>7</td><td>7</td><td>7</td><td>7</td><td>7</td><td><input type='checkbox' id='flight-status-7' value='1' onchange='saveFlightStatus(&quot;7&quot;)' '=''><label for='flight-status-7'>on</label></td></tr><tr style='display: none;'><td>8</td><td>8</td><td>8</td><td>8</td><td>8</td><td><input type='checkbox' id='flight-status-8' value='1' onchange='saveFlightStatus(&quot;8&quot;)' '=''><label for='flight-status-8'>on</label></td></tr><tr style='display: none;'><td>9</td><td>9</td><td>9</td><td>9</td><td>9</td><td><input type='checkbox' id='flight-status-9' value='1' onchange='saveFlightStatus(&quot;9&quot;)' '=''><label for='flight-status-9'>on</label></td></tr><tr style='display: none;'><td>10</td><td>10</td><td>10</td><td>10</td><td>10</td><td><input type='checkbox' id='flight-status-10' value='1' onchange='saveFlightStatus(&quot;10&quot;)' '=''><label for='flight-status-10'>on</label></td></tr><tr style='display: none;'><td>11</td><td>11</td><td>11</td><td>11</td><td>11</td><td><input type='checkbox' id='flight-status-11' value='1' onchange='saveFlightStatus(&quot;11&quot;)' '=''><label for='flight-status-11'>on</label></td></tr><tr style='display: none;'><td>12</td><td>12</td><td>12</td><td>12</td><td>12</td><td><input type='checkbox' id='flight-status-12' value='1' onchange='saveFlightStatus(&quot;12&quot;)' '=''><label for='flight-status-12'>on</label></td></tr><tr style='display: none;'><td>13</td><td>13</td><td>13</td><td>13</td><td>13</td><td><input type='checkbox' id='flight-status-13' value='1' onchange='saveFlightStatus(&quot;13&quot;)' '=''><label for='flight-status-13'>on</label></td></tr><tr style='display: none;'><td>14</td><td>14</td><td>14</td><td>14</td><td>14</td><td><input type='checkbox' id='flight-status-14' value='1' onchange='saveFlightStatus(&quot;14&quot;)' '=''><label for='flight-status-14'>on</label></td></tr><tr style='display: none;'><td>15</td><td>15</td><td>15</td><td>15</td><td>15</td><td><input type='checkbox' id='flight-status-15' value='1' onchange='saveFlightStatus(&quot;15&quot;)' '=''><label for='flight-status-15'>on</label></td></tr><tr style='display: none;'><td>16</td><td>16</td><td>16</td><td>16</td><td>16</td><td><input type='checkbox' id='flight-status-16' value='1' onchange='saveFlightStatus(&quot;16&quot;)' '=''><label for='flight-status-16'>on</label></td></tr><tr style='display: none;'><td>17</td><td>17</td><td>17</td><td>17</td><td>17</td><td><input type='checkbox' id='flight-status-17' value='1' onchange='saveFlightStatus(&quot;17&quot;)' '=''><label for='flight-status-17'>on</label></td></tr><tr style='display: none;'><td>18</td><td>18</td><td>18</td><td>18</td><td>18</td><td><input type='checkbox' id='flight-status-18' value='1' onchange='saveFlightStatus(&quot;18&quot;)' '=''><label for='flight-status-18'>on</label></td></tr><tr style='display: none;'><td>19</td><td>19</td><td>19</td><td>19</td><td>19</td><td><input type='checkbox' id='flight-status-19' value='1' onchange='saveFlightStatus(&quot;19&quot;)' '=''><label for='flight-status-19'>on</label></td></tr><tr style='display: none;'><td>20</td><td>20</td><td>20</td><td>20</td><td>20</td><td><input type='checkbox' id='flight-status-20' value='1' onchange='saveFlightStatus(&quot;20&quot;)' '=''><label for='flight-status-20'>on</label></td></tr><tr style='display: none;'><td>21</td><td>21</td><td>21</td><td>21</td><td>21</td><td><input type='checkbox' id='flight-status-21' value='1' onchange='saveFlightStatus(&quot;21&quot;)' '=''><label for='flight-status-21'>on</label></td></tr><tr style='display: none;'><td>22</td><td>22</td><td>22</td><td>22</td><td>22</td><td><input type='checkbox' id='flight-status-22' value='1' onchange='saveFlightStatus(&quot;22&quot;)' '=''><label for='flight-status-22'>on</label></td></tr><tr style='display: none;'><td>23</td><td>23</td><td>23</td><td>23</td><td>23</td><td><input type='checkbox' id='flight-status-23' value='1' onchange='saveFlightStatus(&quot;23&quot;)' '=''><label for='flight-status-23'>on</label></td></tr><tr style='display: none;'><td>24</td><td>24</td><td>24</td><td>24</td><td>24</td><td><input type='checkbox' id='flight-status-24' value='1' onchange='saveFlightStatus(&quot;24&quot;)' '=''><label for='flight-status-24'>on</label></td></tr><tr style='display: none;'><td>25</td><td>25</td><td>25</td><td>25</td><td>25</td><td><input type='checkbox' id='flight-status-25' value='1' onchange='saveFlightStatus(&quot;25&quot;)' '=''><label for='flight-status-25'>on</label></td></tr><tr style='display: none;'><td>26</td><td>26</td><td>26</td><td>26</td><td>26</td><td><input type='checkbox' id='flight-status-26' value='1' onchange='saveFlightStatus(&quot;26&quot;)' '=''><label for='flight-status-26'>on</label></td></tr><tr style='display: none;'><td>27</td><td>27</td><td>27</td><td>27</td><td>27</td><td><input type='checkbox' id='flight-status-27' value='1' onchange='saveFlightStatus(&quot;27&quot;)' '=''><label for='flight-status-27'>on</label></td></tr><tr style='display: none;'><td>28</td><td>28</td><td>28</td><td>28</td><td>28</td><td><input type='checkbox' id='flight-status-28' value='1' onchange='saveFlightStatus(&quot;28&quot;)' '=''><label for='flight-status-28'>on</label></td></tr><tr style='display: none;'><td>29</td><td>29</td><td>29</td><td>29</td><td>29</td><td><input type='checkbox' id='flight-status-29' value='1' onchange='saveFlightStatus(&quot;29&quot;)' '=''><label for='flight-status-29'>on</label></td></tr><tr style='display: none;'><td>30</td><td>30</td><td>30</td><td>30</td><td>30</td><td><input type='checkbox' id='flight-status-30' value='1' onchange='saveFlightStatus(&quot;30&quot;)' '=''><label for='flight-status-30'>on</label></td></tr><tr style='display: none;'><td>31</td><td>31</td><td>31</td><td>31</td><td>31</td><td><input type='checkbox' id='flight-status-31' value='1' onchange='saveFlightStatus(&quot;31&quot;)' '=''><label for='flight-status-31'>on</label></td></tr><tr style='display: none;'><td>32</td><td>32</td><td>32</td><td>32</td><td>32</td><td><input type='checkbox' id='flight-status-32' value='1' onchange='saveFlightStatus(&quot;32&quot;)' '=''><label for='flight-status-32'>on</label></td></tr><tr style='display: none;'><td>33</td><td>33</td><td>33</td><td>33</td><td>33</td><td><input type='checkbox' id='flight-status-33' value='1' onchange='saveFlightStatus(&quot;33&quot;)' '=''><label for='flight-status-33'>on</label></td></tr><tr style='display: none;'><td>34</td><td>34</td><td>34</td><td>34</td><td>34</td><td><input type='checkbox' id='flight-status-34' value='1' onchange='saveFlightStatus(&quot;34&quot;)' '=''><label for='flight-status-34'>on</label></td></tr><tr style='display: none;'><td>35</td><td>35</td><td>35</td><td>35</td><td>35</td><td><input type='checkbox' id='flight-status-35' value='1' onchange='saveFlightStatus(&quot;35&quot;)' '=''><label for='flight-status-35'>on</label></td></tr><tr style='display: none;'><td>36</td><td>36</td><td>36</td><td>36</td><td>36</td><td><input type='checkbox' id='flight-status-36' value='1' onchange='saveFlightStatus(&quot;36&quot;)' '=''><label for='flight-status-36'>on</label></td></tr><tr style='display: none;'><td>37</td><td>37</td><td>37</td><td>37</td><td>37</td><td><input type='checkbox' id='flight-status-37' value='1' onchange='saveFlightStatus(&quot;37&quot;)' '=''><label for='flight-status-37'>on</label></td></tr><tr style='display: none;'><td>38</td><td>38</td><td>38</td><td>38</td><td>38</td><td><input type='checkbox' id='flight-status-38' value='1' onchange='saveFlightStatus(&quot;38&quot;)' '=''><label for='flight-status-38'>on</label></td></tr><tr style='display: none;'><td>39</td><td>39</td><td>39</td><td>39</td><td>39</td><td><input type='checkbox' id='flight-status-39' value='1' onchange='saveFlightStatus(&quot;39&quot;)' '=''><label for='flight-status-39'>on</label></td></tr><tr style='display: none;'><td>40</td><td>40</td><td>40</td><td>40</td><td>40</td><td><input type='checkbox' id='flight-status-40' value='1' onchange='saveFlightStatus(&quot;40&quot;)' '=''><label for='flight-status-40'>on</label></td></tr><tr style='display: none;'><td>41</td><td>41</td><td>41</td><td>41</td><td>41</td><td><input type='checkbox' id='flight-status-41' value='1' onchange='saveFlightStatus(&quot;41&quot;)' '=''><label for='flight-status-41'>on</label></td></tr><tr style='display: none;'><td>42</td><td>42</td><td>42</td><td>42</td><td>42</td><td><input type='checkbox' id='flight-status-42' value='1' onchange='saveFlightStatus(&quot;42&quot;)' '=''><label for='flight-status-42'>on</label></td></tr><tr style='display: none;'><td>43</td><td>43</td><td>43</td><td>43</td><td>43</td><td><input type='checkbox' id='flight-status-43' value='1' onchange='saveFlightStatus(&quot;43&quot;)' '=''><label for='flight-status-43'>on</label></td></tr><tr style='display: none;'><td>44</td><td>44</td><td>44</td><td>44</td><td>44</td><td><input type='checkbox' id='flight-status-44' value='1' onchange='saveFlightStatus(&quot;44&quot;)' '=''><label for='flight-status-44'>on</label></td></tr><tr style='display: none;'><td>45</td><td>45</td><td>45</td><td>45</td><td>45</td><td><input type='checkbox' id='flight-status-45' value='1' onchange='saveFlightStatus(&quot;45&quot;)' '=''><label for='flight-status-45'>on</label></td></tr><tr style='display: none;'><td>46</td><td>46</td><td>46</td><td>46</td><td>46</td><td><input type='checkbox' id='flight-status-46' value='1' onchange='saveFlightStatus(&quot;46&quot;)' '=''><label for='flight-status-46'>on</label></td></tr><tr style='display: none;'><td>47</td><td>47</td><td>47</td><td>47</td><td>47</td><td><input type='checkbox' id='flight-status-47' value='1' onchange='saveFlightStatus(&quot;47&quot;)' '=''><label for='flight-status-47'>on</label></td></tr><tr style='display: none;'><td>48</td><td>48</td><td>48</td><td>48</td><td>48</td><td><input type='checkbox' id='flight-status-48' value='1' onchange='saveFlightStatus(&quot;48&quot;)' '=''><label for='flight-status-48'>on</label></td></tr><tr style='display: none;'><td>49</td><td>49</td><td>49</td><td>49</td><td>49</td><td><input type='checkbox' id='flight-status-49' value='1' onchange='saveFlightStatus(&quot;49&quot;)' '=''><label for='flight-status-49'>on</label></td></tr></tbody></table></body></html>");
//		
//	}
	
	
}
