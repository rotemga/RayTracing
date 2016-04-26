package RayTracing;

import java.awt.Transparency;
import java.awt.color.*;
import java.awt.image.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;


import java.util.List;

import javax.imageio.ImageIO;
import javax.rmi.CORBA.Util;

//import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils.Collections;

/**
 *  Main class for ray tracing exercise.
 */
public class RayTracer {

	public int imageWidth;
	public int imageHeight;
	public Scene thisScene;

	/**
	 * Runs the ray tracer. Takes scene file, output image file and image size as input.
	 */
	public static void main(String[] args) {
		try {

			RayTracer tracer = new RayTracer();

                        // Default values:
			tracer.imageWidth = 500;
			tracer.imageHeight = 500;

			if (args.length < 2)
				throw new RayTracerException("Not enough arguments provided. Please specify an input scene file and an output image file for rendering.");

			String sceneFileName = args[0];
			String outputFileName = args[1];

			if (args.length > 3)
			{
				tracer.imageWidth = Integer.parseInt(args[2]);
				tracer.imageHeight = Integer.parseInt(args[3]);
			}


			// Parse scene file:
			tracer.parseScene(sceneFileName);

			// Render scene:
			tracer.renderScene(outputFileName);

//		} catch (IOException e) {
//			System.out.println(e.getMessage());
		} catch (RayTracerException e) {
			System.out.println(e.getMessage());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}


	}

	/**
	 * Parses the scene file and creates the scene. Change this function so it generates the required objects.
	 */
	public void parseScene(String sceneFileName) throws IOException, RayTracerException
	{
		FileReader fr = new FileReader(sceneFileName);

		BufferedReader r = new BufferedReader(fr);
		String line = null;
		int lineNum = 0;
		System.out.println("Started parsing scene file " + sceneFileName);
		
		
		Camera cam =null;
		Settings set = null;
		
		List <Material> mtl = new ArrayList<Material>();
		List<Light> lgt = new ArrayList<Light>();
		
		List <Object3D> objects = new ArrayList<Object3D>();		

		while ((line = r.readLine()) != null)
		{
			line = line.trim();
			++lineNum;

			if (line.isEmpty() || (line.charAt(0) == '#'))
			{  // This line in the scene file is a comment
				continue;
			}
			else
			{
				String code = line.substring(0, 3).toLowerCase();
				// Split according to white space characters:
				String[] params = line.substring(3).trim().toLowerCase().split("\\s+");

				if (code.equals("cam"))
				{
                    // Add code here to parse camera parameters

					
					Tuple3D position = new Tuple3D(params[0],params[1],params[2]);
					
					Tuple3D look_at_point = new Tuple3D(params[3],params[4],params[5]);
					
					Tuple3D up_vector = new Tuple3D(params[6],params[7],params[8]);
					
					float screen_dist = Float.parseFloat(params[9]);
					float screen_width = Float.parseFloat(params[10]);	

					cam = new Camera(position,look_at_point,up_vector,screen_dist,screen_width);
					
					System.out.println(String.format("Parsed camera parameters (line %d)", lineNum));
				}
				else if (code.equals("set"))
				{
                                        // Add code here to parse general settings parameters
					Color background_col = new Color(params[0],params[1],params[2]);
					int root_num_shadow_rays = Integer.parseInt(params[3]);
					int max_num_recurs = Integer.parseInt(params[4]);
					set = new Settings(background_col,root_num_shadow_rays,max_num_recurs);

					System.out.println(String.format("Parsed general settings (line %d)", lineNum));
				}
				else if (code.equals("mtl"))
				{
                                        // Add code here to parse material parameters
					
					Color diffuse_col = new Color(params[0],params[1],params[2]);
					
					Color specular_col = new Color(params[3],params[4],params[5]);

					Color reflection_col = new Color(params[6],params[7],params[8]);
					
					float phong_specular_coeff = Float.parseFloat(params[9]);
					float transparency = Float.parseFloat(params[10]);
					
					Material tmp = new Material(diffuse_col, specular_col, phong_specular_coeff, reflection_col, transparency);
					mtl.add(tmp);
				

					System.out.println(String.format("Parsed material (line %d)", lineNum));
				}
				else if (code.equals("sph"))
				{
                                        // Add code here to parse sphere parameters

                                        // Example (you can implement this in many different ways!):
					                    // Sphere sphere = new Sphere();
                                        // sphere.setCenter(params[0], params[1], params[2]);
                                        // sphere.setRadius(params[3]);
                                        // sphere.setMaterial(params[4]);
					
					
					Tuple3D position = new Tuple3D(params[0],params[1],params[2]);
					double raduis = Double.parseDouble(params[3]);
					
					int material_index = Integer.parseInt(params[4]);
					Sphere tmp = new Sphere(position, raduis, material_index);
					objects.add(tmp);

					System.out.println(String.format("Parsed sphere (line %d)", lineNum));
				}
				else if (code.equals("pln"))
				{
                                        // Add code here to parse plane parameters
					Tuple3D normal = new Tuple3D(params[0],params[1],params[2]);
					int offset = Integer.parseInt(params[3]);
					int material_index = Integer.parseInt(params[4]);
					
					objects.add(new Plane(normal, offset, material_index));
					
					System.out.println(String.format("Parsed plane (line %d)", lineNum));
				}
				else if (code.equals("cyl"))
				{
                                        // Add code here to parse cylinder parameters
					
					Tuple3D position = new Tuple3D(params[0],params[1],params[2]);
					double length = Double.parseDouble(params[3]);
					double radius = Double.parseDouble(params[4]);
					
					Tuple3D rotation = new Tuple3D(params[5],params[6],params[7]);
					int material_index = Integer.parseInt(params[8]);
					
					objects.add(new Cylinder(position, length, radius, rotation, material_index));

					System.out.println(String.format("Parsed cylinder (line %d)", lineNum));
				}
				else if (code.equals("lgt"))
				{
                                        // Add code here to parse light parameters
					
					Tuple3D position = new Tuple3D(params[0],params[1],params[2]);
					Color color = new Color(params[3],params[4],params[5]);
					
					float specular_intensity = Float.parseFloat(params[6]);
					float shadow_intensity = Float.parseFloat(params[7]);
					float radius = Float.parseFloat(params[8]);
					
					lgt.add(new Light(position, color, specular_intensity, shadow_intensity, radius));

					


					

					System.out.println(String.format("Parsed light (line %d)", lineNum));
				}
				else
				{
					System.out.println(String.format("ERROR: Did not recognize object: %s (line %d)", code, lineNum));
				}
			}
			
		}

                // It is recommended that you check here that the scene is valid,
                // for example camera settings and all necessary materials were defined.

		r.close();
		System.out.println("Finished parsing scene file " + sceneFileName);
		
		
		if(cam==null){
			throw new RuntimeException("Error: no camera specification found");
		}
		if(set==null){	
			throw new RuntimeException("Error: no settings found");
		}
		thisScene = new Scene(cam, set, mtl, objects, lgt);
		
	}

	/**
	 * Renders the loaded scene and saves it to the specified file location.
	 */
	public void renderScene(String outputFileName)
	{
		long startTime = System.currentTimeMillis();

		// Create a byte array to hold the pixel data:
		byte[] rgbData = new byte[this.imageWidth * this.imageHeight * 3];

		
		
		
		
		System.out.println("rendering image: "+imageWidth+" * "+imageHeight);

		for (int i = 0; i < this.imageWidth; i++) {
		
			for (int j = 0; j < this.imageHeight; j++) {
				
				Ray ray = constructRayThroughPixel(i, j,this.imageWidth,this.imageHeight,thisScene.getCam());

				Intersection hit = new Intersection(this.thisScene.getObjects(), ray);
				
				Color hitColor = getColor(0, hit);
				//Color hitColor=GetColor(hit);
				rgbData[3*(i+this.imageWidth*j)] = Color.toByte(hitColor.getR());
				rgbData[3*(i+this.imageWidth*j)+1] = Color.toByte(hitColor.getG());
				rgbData[3*(i+this.imageWidth*j)+2] = Color.toByte(hitColor.getB());
				//System.out.format("just inserted: %d %d %d \n",rgbData[i+this.imageWidth*j],rgbData[i+this.imageWidth*j+1],rgbData[i+this.imageWidth*j+2]);
				
			}
			
			
		}

		long endTime = System.currentTimeMillis();
		Long renderTime = endTime - startTime;

                // The time is measured for your own conveniece, rendering speed will not affect your score
                // unless it is exceptionally slow (more than a couple of minutes)
		System.out.println("Finished rendering scene in " + renderTime.toString() + " milliseconds.");

                // This is already implemented, and should work without adding any code.
		saveImage(this.imageWidth, rgbData, outputFileName);

		System.out.println("Saved file " + outputFileName);

	}

	//////////////////////// FUNCTIONS TO SAVE IMAGES IN PNG FORMAT //////////////////////////////////////////

	/*
	 * Saves RGB data as an image in png format to the specified location.
	 */
	public static void saveImage(int width, byte[] rgbData, String fileName)
	{
		try {

			BufferedImage image = bytes2RGB(width, rgbData);
			ImageIO.write(image, "png", new File(fileName));

		} catch (IOException e) {
			System.out.println("ERROR SAVING FILE: " + e.getMessage());
		}

	}

	/*
	 * Producing a BufferedImage that can be saved as png from a byte array of RGB values.
	 */
	public static BufferedImage bytes2RGB(int width, byte[] buffer) {
	    int height = buffer.length / width / 3;
	    ColorSpace cs = ColorSpace.getInstance(ColorSpace.CS_sRGB);
	    ColorModel cm = new ComponentColorModel(cs, false, false,
	            Transparency.OPAQUE, DataBuffer.TYPE_BYTE);
	    SampleModel sm = cm.createCompatibleSampleModel(width, height);
	    DataBufferByte db = new DataBufferByte(buffer, width * height);
	    WritableRaster raster = Raster.createWritableRaster(sm, db, null);
	    BufferedImage result = new BufferedImage(cm, raster, false, null);

	    return result;
	}

	@SuppressWarnings("serial")
	public static class RayTracerException extends Exception {
		public RayTracerException(String msg) {  super(msg); }
	}

	
	
	
	public Ray constructRayThroughPixel(int i, int j, int width, int height, Camera Cam) {
		double screen_heigth = (height*Cam.getScreen_width())/width;
		double pixelSizeWidth=Cam.getScreen_width()/width;
		double pixelSizeHeight = screen_heigth/height;
		
		double offsetSide	=	pixelSizeWidth*(	(i-width /2f  ) +0.5);
		double offsetVertical	=	pixelSizeHeight*(	(j-height/2f) +0.5); 
		
		Tuple3D camPosition=Cam.getPosition();
		Tuple3D cameraDirection = new Tuple3D(Cam.getLook_at_point(),Cam.getPosition()).normalized();
		Tuple3D viewPlaneCenter= Cam.getPosition().add(cameraDirection.scale(Cam.getScreen_distance()));
		
		Tuple3D Up =  Cam.getUp_vector();
		Tuple3D Side = Up.cross(cameraDirection).normalized();
		Tuple3D Vertical = Side.cross(cameraDirection).normalized();

		Tuple3D pixelPosition = viewPlaneCenter.add(Side.scale(offsetSide)).add(Vertical.scale(offsetVertical)); 
		
		return new Ray(camPosition, pixelPosition.sub(camPosition));
	}
	
	
	private Color getColor(int currentLevelRecurse, Intersection hit) {
		if(currentLevelRecurse==10){System.out.println("10"); return new Color(0,0,0);}
		if (currentLevelRecurse > thisScene.getSet().getMax_num_recurstion())	return thisScene.getSet().getBackgrouad_col();
		
		
		Intersection.SingleIntersection curIntersection = hit.getIntersectionByIndex(currentLevelRecurse);
		
		if(curIntersection==null) return thisScene.getSet().getBackgrouad_col();	
		
		Object3D curObj=curIntersection.getObject();
		Material material = curObj.getMaterial();
		
		double transparancy=material.getTransparency();
		
		Color backgroundColor=(transparancy>0)?getColor(currentLevelRecurse+1,hit):new Color(0,0,0)/*doesn't matter*/;
		//Color backgroundColor=getColor(currentLevelRecurse+1,hit);
		
		
		Color diffuse = new Color(0,0,0);// material.getDiffuse_col();
		
		//System.out.println("before light loop");
		for(Light light: thisScene.getLgt()){
			//System.out.println("in light loop");
			Tuple3D lightPos=light.getPosition();
			Tuple3D lightDir=lightPos.sub(curIntersection.getPosition()).normalized();
			
			double intensity = curIntersection.getNormal().dotFactor(lightDir);
			
			Color lightColor = light.getColor();
			Color diffuseForThisLight = lightColor.scale(intensity);
			diffuse= diffuse.add(diffuseForThisLight);
			//Ray lightBeam = new Ray(lightPos,lightDir);
			//Intersection light_obj_intr= new Intersection(curObj,lightBeam);
			
		}
		diffuse=diffuse.mult(material.getDiffuse_col()); 
				
		return diffuse.scale(1-transparancy).add(backgroundColor.scale(transparancy));
	}
}