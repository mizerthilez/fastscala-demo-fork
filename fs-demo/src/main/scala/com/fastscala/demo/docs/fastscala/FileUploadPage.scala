package com.fastscala.demo.docs.fastscala

import com.fastscala.core.{FSContext, FSSessionVarOpt, FSUploadedFile}
import com.fastscala.demo.docs.MultipleCodeExamples3Page
import com.fastscala.js.Js
import com.fastscala.scala_xml.js.JS
import com.fastscala.components.bootstrap5.utils.FileUpload
import com.fastscala.scala_xml.ScalaXmlElemUtils.RichElem

import java.util.Base64

// === code sample ===
object UploadedImage extends FSSessionVarOpt[FSUploadedFile]()
// === code sample ===

class FileUploadPage extends MultipleCodeExamples3Page() {

  override def pageTitle: String = "File Upload Example"

  override def renderAllCodeSamples()(implicit fsc: FSContext): Unit = {
    renderCodeSampleAndAutoClosePreviousOne("Source") {
      import com.fastscala.components.bootstrap5.helpers.BSHelpers.*
      JS.rerenderable(rerenderer => implicit fsc => {
        div.border.p_2.rounded.apply {
          UploadedImage() match {
            case Some(uploadedFile) =>
              h3.apply("Uploaded image:") ++
                <img class="w-100" src={s"data:${uploadedFile.contentType};base64, " + Base64.getEncoder.encodeToString(uploadedFile.content)}></img>.mx_auto.my_4.d_block
            case None =>
              h3.apply("Upload an image:") ++
                FileUpload(
                  uploadedFile => {
                    UploadedImage() = uploadedFile.head
                    rerenderer.rerender()
                  })
          }
        }
      }).render()
    }
    closeCodeSample()
  }
}
